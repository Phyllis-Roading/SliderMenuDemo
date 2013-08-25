package phyllis.roading.slidermenudemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import cn.sharesdk.onekeyshare.ShareAllGird;
import cn.sharesdk.onekeyshare.SharePage;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


public class ColorMenuFragment extends ListFragment {
	
	private SlidingMenu menu;

	public ColorMenuFragment(SlidingMenu menu){
		this.menu=menu;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String[] colors = getResources().getStringArray(R.array.color_names);
		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(), 
				android.R.layout.simple_list_item_1, android.R.id.text1, colors);
		setListAdapter(colorAdapter);
	}

	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		Fragment newContent = null;
		switch (position) {
		case 0:
			newContent = new ColorFragment(R.color.red);
			break;
		case 1:
			newContent = new ColorFragment(R.color.green);
			break;
		case 2:
			newContent = new ColorFragment(R.color.blue);
			break;
		case 3:
			newContent = new ColorFragment(android.R.color.white);
			break;
		case 4:
			newContent = new ColorFragment(android.R.color.black);
			break;
		case 5:
			showGrid(false);
			break;
		}
		if (newContent != null)
			switchFragment(newContent);
	}

	private void showGrid(boolean silent) {
		Intent i = new Intent(menu.getContext(), ShareAllGird.class);
		// ����ʱNotification��ͼ��
		i.putExtra("notif_icon", R.drawable.ic_launcher);
		// ����ʱNotification�ı���
		i.putExtra("notif_title", menu.getContext().getString(R.string.app_name));

		// address�ǽ����˵�ַ��������Ϣ���ʼ�ʹ�ã�������Բ��ṩ
		i.putExtra("address", "12345678901");
		// title���⣬��ӡ��ʼǡ����䡢��Ϣ��΢�ţ��������Ѻ�����Ȧ������������QQ�ռ�ʹ�ã�������Բ��ṩ
		i.putExtra("title", menu.getContext().getString(R.string.share));
		// titleUrl�Ǳ�����������ӣ�������������QQ�ռ�ʹ�ã�������Բ��ṩ
		i.putExtra("titleUrl", "http://sharesdk.cn");
		// text�Ƿ����ı�������ƽ̨����Ҫ����ֶ�
		i.putExtra("text", menu.getContext().getString(R.string.share_content));
		// imagePath�Ǳ��ص�ͼƬ·������Linked-In�������ƽ̨��֧������ֶ�
		//i.putExtra("imagePath", MainActivity.TEST_IMAGE);
		// imageUrl��ͼƬ������·��������΢������������QQ�ռ��Linked-In֧�ִ��ֶ�
		//i.putExtra("imageUrl", "http://img.appgo.cn/imgs/sharesdk/content/2013/06/13/1371120300254.jpg");
		// url����΢�ţ��������Ѻ�����Ȧ����ʹ�ã�������Բ��ṩ
		i.putExtra("url", "http://sharesdk.cn");
		// thumbPath������ͼ�ı���·��������΢�ţ��������Ѻ�����Ȧ����ʹ�ã�������Բ��ṩ
		//i.putExtra("thumbPath", MainActivity.TEST_IMAGE);
		// appPath�Ǵ�����Ӧ�ó���ı���·��������΢�ţ��������Ѻ�����Ȧ����ʹ�ã�������Բ��ṩ
		//i.putExtra("appPath", MainActivity.TEST_IMAGE);
		// comment���Ҷ�������������ۣ�������������QQ�ռ�ʹ�ã�������Բ��ṩ
		i.putExtra("comment", menu.getContext().getString(R.string.share));
		// site�Ƿ�������ݵ���վ���ƣ�����QQ�ռ�ʹ�ã�������Բ��ṩ
		i.putExtra("site", menu.getContext().getString(R.string.app_name));
		// siteUrl�Ƿ�������ݵ���վ��ַ������QQ�ռ�ʹ�ã�������Բ��ṩ
		i.putExtra("siteUrl", "http://sharesdk.cn");

		// foursquare����ʱ�ĵط���
		i.putExtra("venueName", "Southeast in China");
		// foursquare����ʱ�ĵط�����
		i.putExtra("venueDescription", "This is a beautiful place!");
		// foursquare����ʱ�ĵط�γ��
		i.putExtra("latitude", 23.122619f);
		// foursquare����ʱ�ĵط�����
		i.putExtra("longitude", 113.372338f);

		// �Ƿ�ֱ�ӷ���
		i.putExtra("silent", silent);
		// �����Զ�����ⲿ�ص�
		i.putExtra("callback", OneKeyShareCallback.class.getName());
		menu.getContext().startActivity(i);
	}


	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;
		
		if (getActivity() instanceof FragmentChangeActivity) {
			FragmentChangeActivity fca = (FragmentChangeActivity) getActivity();
			fca.switchContent(fragment);
		} 
	}
}
