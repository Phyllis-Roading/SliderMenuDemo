/*
 * ������վ:http://www.ShareSDK.cn
 * ����֧��QQ: 4006852216
 * �ٷ�΢��:ShareSDK   ����������°汾�Ļ������ǽ����һʱ��ͨ��΢�Ž��汾�����������͸��������ʹ�ù��������κ����⣬Ҳ����ͨ��΢��������ȡ����ϵ�����ǽ�����24Сʱ�ڸ���ظ���
 *
 * Copyright (c) 2013�� ShareSDK.cn. All rights reserved.
 */

package phyllis.roading.slidermenudemo;

import java.util.HashMap;
import cn.sharesdk.framework.AbstractWeibo;
import cn.sharesdk.framework.WeiboActionListener;

/**
 * OneKeyShareCallback�ǿ�ݷ����ܵ�һ�����ⲿ�ص���ʾ����
 *��ʾ�����ͨ�����extra�ķ���������ݷ���ķ������ص���
 *���������Զ��崦��
 */
public class OneKeyShareCallback implements WeiboActionListener {

	public void onComplete(AbstractWeibo weibo, int action,
			HashMap<String, Object> res) {
		System.out.println(res.toString());
		// ��������ӷ���ɹ��Ĵ������
	}

	public void onError(AbstractWeibo weibo, int action, Throwable t) {
		t.printStackTrace();
		// ��������ӷ���ʧ�ܵĴ������
	}

	public void onCancel(AbstractWeibo weibo, int action) {
		// ���������ȡ������Ĵ������
	}

}
