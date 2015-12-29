package com.example.robot;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter  extends BaseAdapter {
	private Context context;
	private List<dataTransfer> data;
	private LayoutInflater mInflater;
	
	private final int ALLITEM = 2;
	private final int ROBOT = 0;
	private final int USER = 1;
	
	public ListViewAdapter(Context context, List<dataTransfer> data)
	{
		mInflater = LayoutInflater.from(context);
		this.data = data;
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	/**
	 * �õ�Item�����ͣ��ǶԷ�����������Ϣ�������Լ����ͳ�ȥ��
	 */
	public int getItemViewType(int position) {
		dataTransfer entity = data.get(position);

		if (entity.getRobotUser() == 0) {//�յ�����Ϣ
			return ROBOT;
		} else if(entity.getRobotUser() == 1){//�Լ����͵���Ϣ
			return USER;
		}
		return position;
	}

	/**
	 * Item���͵�����
	 */
	public int getViewTypeCount() {
		return ALLITEM;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		dataTransfer entity = data.get(position);
		int isComMsg = entity.getRobotUser();

		ViewHolder viewHolder = null;
		if (convertView == null) {
			if (isComMsg == 0) {
				convertView = mInflater.inflate(
						R.layout.left, null);
			} else if(isComMsg == 1){
				convertView = mInflater.inflate(
						R.layout.right, null);
			}
			viewHolder = new ViewHolder();
//			viewHolder.tvSendTime = (TextView) convertView
//					.findViewById(R.id.tv_sendtime);
			viewHolder.tvUserName = (TextView) convertView
					.findViewById(R.id.tv_username);
			viewHolder.tvContent = (TextView) convertView
					.findViewById(R.id.tv_chatcontent);
			viewHolder.isComMsg = isComMsg;

			convertView.setTag(viewHolder);
		} else {
			
			viewHolder = (ViewHolder) convertView.getTag();
		}
	//	viewHolder.tvSendTime.setText(entity.getDate());
		viewHolder.tvUserName.setText(entity.getName());
		viewHolder.tvContent.setText(entity.getWord());
		return convertView;
	}
	
	static class ViewHolder {
		public TextView tvSendTime;
		public TextView tvUserName;
		public TextView tvContent;
		public int isComMsg = 0;
	}

}
