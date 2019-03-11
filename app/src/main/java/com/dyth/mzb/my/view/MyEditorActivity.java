package com.dyth.mzb.my.view;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dyth.mzb.R;
import com.dyth.mzb.base.BaseActivity;
import com.dyth.mzb.my.base.userinfomation.UserInfomaton;
import com.dyth.mzb.my.contact.UpLoadHeaderContract;
import com.dyth.mzb.my.contact.UpdataContract;
import com.dyth.mzb.my.contact.UserInfoContract;
import com.dyth.mzb.my.presenter.UpDataPresenterImpl;
import com.dyth.mzb.my.presenter.UpLoadHeaderPresenterImpl;
import com.dyth.mzb.my.presenter.UserInfoPresenterImpl;
import com.dyth.mzb.utils.ImgUtils;

import java.io.File;
import java.util.Calendar;


/**
 * Created by Lenovo on 2019/1/3.
 */

public class MyEditorActivity extends BaseActivity implements UserInfoContract.IUserInfoView, UpLoadHeaderContract.IUpLoadHeaderView, View.OnClickListener, UpdataContract.IUpdataView {

    private Toolbar mtoolbar;
    private UserInfoPresenterImpl userInfoPresenter;
    private UpLoadHeaderPresenterImpl upLoadHeaderPresenter;
    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    protected static Uri tempUri;
    private AlertDialog.Builder builder;
    private UpDataPresenterImpl upDataPresenter;
    private ImageView mHeadImage;
    private ImageView mGoHead;
    /**
     * 151348795420
     */
    private EditText mNameNumber;
    private ImageView mGoName;
    /**
     * 男
     */
    private EditText mSexSex;
    private ImageView mGoSex;
    /**
     * 1990-01-01
     */
    private TextView mBirthdayData;
    private ImageView mGoBirthday;
    /**
     * 人力资源
     */
    private EditText mProfessional;
    private ImageView mGoProfessional;
    /**
     * 个人简介
     */
    private TextView mPersonalProfile;
    /**  */
    private EditText mInfo;
    private ImageView mGoInfo;
    private LinearLayout mLay;

    private Calendar calendar = null;
    private int year;
    private int month;
    private int day;
    private UserInfomaton userInfomaton;


    @Override
    protected int getLayoutId() {
        return R.layout.editor_main;
    }

    @Override
    protected void initView() {
        mtoolbar = findViewById(R.id.toolbar);
        mHeadImage = (ImageView) findViewById(R.id.head_image);
        mGoHead = (ImageView) findViewById(R.id.Go_head);
        mNameNumber = (EditText) findViewById(R.id.name_number);
        mGoName = (ImageView) findViewById(R.id.Go_name);
        mSexSex = (EditText) findViewById(R.id.sex_sex);
        mGoSex = (ImageView) findViewById(R.id.Go_sex);
        mBirthdayData = (TextView) findViewById(R.id.birthday_data_);
        mGoBirthday = (ImageView) findViewById(R.id.Go_birthday);
        mProfessional = (EditText) findViewById(R.id.professional);
        mGoProfessional = (ImageView) findViewById(R.id.Go_professional);
        mPersonalProfile = (TextView) findViewById(R.id.personalProfile);
        mInfo = (EditText) findViewById(R.id.info);
        mGoInfo = (ImageView) findViewById(R.id.Go_info);
        mLay = (LinearLayout) findViewById(R.id.Lay);
        mtoolbar.setTitle("");
        setSupportActionBar(mtoolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setDisplayShowTitleEnabled(false);
        mtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mGoHead.setOnClickListener(this);
        mGoName.setOnClickListener(this);
        mGoBirthday.setOnClickListener(this);
        mGoProfessional.setOnClickListener(this);
        mGoSex.setOnClickListener(this);


        builder = new AlertDialog.Builder(this);
        builder.setTitle("设置头像");
        String[] items = {"选择本地照片", "拍照"};
        builder.setNegativeButton("取消", null);
        builder.setItems(items, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case CHOOSE_PICTURE:
                        Intent openAlbumIntent = new Intent(
                                Intent.ACTION_PICK,
                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
                        break;
                    case TAKE_PICTURE:
                        Intent openCameraIntent = new Intent(
                                MediaStore.ACTION_IMAGE_CAPTURE);
                        tempUri = Uri.fromFile(new File(Environment
                                .getExternalStorageDirectory(), "image.jpg"));
                        // 指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
                        startActivityForResult(openCameraIntent, TAKE_PICTURE);
                        break;
                }
            }
        });
        builder.create();
        mGoHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.show();
            }
        });


    }

    @Override
    protected void getData() {


    }

    @Override
    protected void getpresenter() {
        userInfoPresenter = new UserInfoPresenterImpl(this);
        userInfoPresenter.getUserInfo();
        upLoadHeaderPresenter = new UpLoadHeaderPresenterImpl(this);
        upDataPresenter = new UpDataPresenterImpl(this);
    }


    @Override
    public void getUserInfoData(Object o) {
        userInfomaton = (UserInfomaton) o;
        Glide.with(this).load(userInfomaton.getData().getHeadImagePath().toString()).apply(new RequestOptions().circleCrop()).into(mHeadImage);
        mBirthdayData.setText(userInfomaton.getData().getBirthday());
        mNameNumber.setText(userInfomaton.getData().getPhone());
        mSexSex.setText(userInfomaton.getData().getSex());
        mProfessional.setText(userInfomaton.getData().getProfessionName());


        final AlertDialog.Builder tiembuilder = new AlertDialog.Builder(this);
        View view = (LinearLayout) getLayoutInflater().inflate(R.layout.time_log, null);
        final DatePicker datePicker = (DatePicker) view.findViewById(R.id.dp);
//设置日期简略显示 否则详细显示 包括:星期\周
        datePicker.setCalendarViewShown(false);
//设置date布局
        tiembuilder.setView(view);
        tiembuilder.setTitle("设置日期信息");
        tiembuilder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //日期格式
                StringBuffer sb = new StringBuffer();
                sb.append(String.format("%d-%02d-%02d",
                        datePicker.getYear(),
                        datePicker.getMonth() + 1,
                        datePicker.getDayOfMonth()));
       /* oplandate.setText(sb);
        //赋值后面闹钟使用
      */
                String str = "";
                int year = datePicker.getYear();
                str+=year+"-";
                int month = datePicker.getMonth()+1;
                if(month>=10){
                    str+=month+"-";
                }else{
                    str+="0"+month+"-";
                }
                int dayOfMonth = datePicker.getDayOfMonth();
                if(dayOfMonth>=10){
                    str+=dayOfMonth;
                }else{
                    str+="0"+dayOfMonth;
                }
                mBirthdayData.setText(str);
                dialog.cancel();
            }
        });
        tiembuilder.setNegativeButton("取  消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        tiembuilder.create();



        mBirthdayData.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               tiembuilder.show();
           }
       });



    }


    @Override
    public void getUpLoadHeaderData(Object o) {

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 如果返回码是可以用的
            switch (requestCode) {
                case TAKE_PICTURE:
                    startPhotoZoom(tempUri); // 开始对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    startPhotoZoom(data.getData()); // 开始对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }
    }

    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    protected void startPhotoZoom(Uri uri) {
        if (uri == null) {
            Log.i("tag", "The uri is not exist.");
        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);
    }

    /**
     * 保存裁剪之后的图片数据
     *
     * @param
     * @param data
     */
    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            photo = ImgUtils.toRoundBitmap(photo, tempUri); // 这个时候的图片已经被处理成圆形的了
            mHeadImage.setImageBitmap(photo);
           uploadPic(photo);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.Go_name:
              upDataPresenter.getUpdata(mBirthdayData.getText().toString(),mNameNumber.getText().toString(),
                      mInfo.getText().toString(),mPersonalProfile.getText().toString(),mSexSex.getText().toString());
                break;
            case R.id.Go_info:
                upDataPresenter.getUpdata(mBirthdayData.getText().toString(),mNameNumber.getText().toString(),
                        mInfo.getText().toString(),mPersonalProfile.getText().toString(),mSexSex.getText().toString());
                break;
            case R.id.Go_sex:
                upDataPresenter.getUpdata(mBirthdayData.getText().toString(),mNameNumber.getText().toString(),
                        mInfo.getText().toString(),mPersonalProfile.getText().toString(),mSexSex.getText().toString());
                break;
            case R.id.Go_birthday:
                upDataPresenter.getUpdata(mBirthdayData.getText().toString(),mNameNumber.getText().toString(),
                        mInfo.getText().toString(),mPersonalProfile.getText().toString(),mSexSex.getText().toString());
                break;
            case R.id.Go_professional:
                upDataPresenter.getUpdata(mBirthdayData.getText().toString(),mNameNumber.getText().toString(),
                        mInfo.getText().toString(),mPersonalProfile.getText().toString(),mSexSex.getText().toString());
                break;

        }
    }

    @Override
    public void getUpdataData(Object o) {

    }




    private void uploadPic(Bitmap photo) {
        Log.e("sflkdgnsflkdngbsfndg","-=---------=-=-=-");
        String imagePath = ImgUtils.savePhoto(photo, Environment
                .getExternalStorageDirectory().getAbsolutePath(), String
                .valueOf(System.currentTimeMillis()));
        Log.e("imagePath", imagePath+"");
        if(imagePath!=null){
            File file = new File(imagePath);
            upLoadHeaderPresenter.getUpLoadHeader(file);
        }
    }

}






