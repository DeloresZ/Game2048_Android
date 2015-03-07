package com.minicoral.game2048;

import net.youmi.android.AdManager;
import net.youmi.android.banner.AdSize;
import net.youmi.android.banner.AdView;
import net.youmi.android.banner.AdViewListener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity
{
	public MainActivity()
	{
		mainActivity = this;
	}

	private TextView tvScore;
	private int score = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// SpotManager.getInstance(this).showSplashSpotAds(this,
		// MainActivity.class);
		tvScore = (TextView) findViewById(R.id.tvSocre);
		AdManager.getInstance(this).init("2aa219599aa11756",
				"3eac5cf83f121b28", false);

		LinearLayout adLayout = (LinearLayout) findViewById(R.id.adLayout);
		AdView adView = new AdView(this, AdSize.FIT_SCREEN);
		adLayout.addView(adView);
		// 实例化广告条
		// AdView adView = new AdView(this, AdSize.FIT_SCREEN);
		//
		// // 获取要嵌入广告条的布局
		// LinearLayout adLayout = (LinearLayout) findViewById(R.id.adLayout);
		//
		// // 将广告条加入到布局中
		// adLayout.addView(adView);
		// 监听广告条接口
		adView.setAdListener(new AdViewListener()
		{

			@Override
			public void onSwitchedAd(AdView arg0)
			{
				Log.i("YoumiAdDemo", "广告条切换");
			}

			@Override
			public void onReceivedAd(AdView arg0)
			{
				Log.i("YoumiAdDemo", "请求广告成功");

			}

			@Override
			public void onFailedToReceivedAd(AdView arg0)
			{
				Log.i("YoumiAdDemo", "请求广告失败");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void clearScore()
	{
		score = 0;
		showScore();
	}

	public void addScore(int s)
	{
		score += s;
		showScore();
	}

	public void showScore()
	{
		tvScore.setText(score + "");
	}

	public static MainActivity mainActivity = null;

	public static MainActivity getMainActivity()
	{
		return mainActivity;
	}

	private void showBanner()
	{

		// 广告条接口调用（适用于应用）
		// 将广告条adView添加到需要展示的layout控件中
		// LinearLayout adLayout = (LinearLayout) findViewById(R.id.adLayout);
		// AdView adView = new AdView(this, AdSize.FIT_SCREEN);
		// adLayout.addView(adView);

		// 广告条接口调用（适用于游戏）

		// 实例化LayoutParams(重要)
		FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.WRAP_CONTENT,
				FrameLayout.LayoutParams.WRAP_CONTENT);
		// 设置广告条的悬浮位置
		layoutParams.gravity = Gravity.BOTTOM | Gravity.RIGHT; // 这里示例为右下角
		// 实例化广告条
		AdView adView = new AdView(this, AdSize.FIT_SCREEN);
		// 调用Activity的addContentView函数

		// 监听广告条接口
		adView.setAdListener(new AdViewListener()
		{

			@Override
			public void onSwitchedAd(AdView arg0)
			{
				Log.i("YoumiAdDemo", "广告条切换");
			}

			@Override
			public void onReceivedAd(AdView arg0)
			{
				Log.i("YoumiAdDemo", "请求广告成功");

			}

			@Override
			public void onFailedToReceivedAd(AdView arg0)
			{
				Log.i("YoumiAdDemo", "请求广告失败");
			}
		});
		this.addContentView(adView, layoutParams);
	}

}
