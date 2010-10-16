package com.mrcongwang.games.dxball.entities;

import com.mrcongwang.games.dxball.managers.EntityManager;

import android.graphics.Canvas;
import android.util.Log;

public class Ball extends DrawableEntity {
	// С����paddle�ľ��룬����pngͼƬ�Ŀ�϶��ɵģ���λ����
	private static final int PADDING_BETWEEN_PADDLE = 2;
	
	// С���״̬���ս�����ϷʱΪinit״̬
	public static final int STATUS_INIT = -1;
	public static final int STATUS_READY_TO_FIRE = 0;
	public static final int STATUS_FLYING = 1;
	public static final int STATUS_HIT = 2;
	private int _status = STATUS_INIT;
	
	// С��ͣ����paddle��ʱ��ƫ��ֵ����ƫ�Ƶ���˿�ʼ��paddle holder���ֵ�1/4��
	private int _offset_to_paddle = 0;
	
	// С����˶����򣬷���Ϊ0��ʾ��ֹ����ֵΪ0-360��Ϊ0ʱ��ʾ��ֱ����
	private int _direction = 0;
	private static final int MAX_FIRE_ANGLE = 45;
	// С����˶��ٶ�, ÿ֡���е�����
	public static final double SPEED_SLOW = 1;	
	public static final double SPEED_NORMAL = 1.5;
	public static final double SPEED_HIGH = 2;	
	private double _speed = SPEED_NORMAL;
	// ��ײ����
	private int _hits = 0;
	private static final int HITS_TO_NORMAL = 10;
	private static final int HITS_TO_HIGH = 20;
	
	
	public Ball(){
		_bitmap = _bitmap_ball_normal;
		setRectFromBitmap();
	}
	
	// �ж��ӿ�
	public void stickToPaddle(){
		final int paddle_width = EntityManager.PADDLE.get_holder_width();
		final float left = EntityManager.PADDLE.get_holder_x() + paddle_width/4 +  - _width/2;
		if(_status == STATUS_READY_TO_FIRE){			
			_x = _offset_to_paddle + left;			
		}
		else{		
			_offset_to_paddle =  (int) (paddle_width/2 * _random.nextDouble());			
			_x = _offset_to_paddle + left;
			_y = EntityManager.PADDLE.get_y() - _height + PADDING_BETWEEN_PADDLE;		
			
		}		
		_status = STATUS_READY_TO_FIRE;
		
	}
	// �״η���ĽǶ�
	public void fire(){		
		if(_status == STATUS_READY_TO_FIRE){
			final int paddle_width = EntityManager.PADDLE.get_holder_width();
			// [----*-----|------*-----]
			// *���ķ�֮һ����|�Ƕ���֮һ����
			// offset_to_paddle �� ��*��ʼ���
			// ƫ��Խ�󣬷����Խ����󲻳���MAX_FIRE_ANGLE
			final int d = paddle_width >> 2;			
			final int angle = (int) ((double)Math.abs(_offset_to_paddle - d) / d * MAX_FIRE_ANGLE);
			if(_offset_to_paddle < d){
				_direction = 360 - angle;
			}
			else{
				_direction = angle;
			}
			Log.i("Ball", "offset = " + _offset_to_paddle + ", direction = " + _direction);
			_speed = SPEED_NORMAL;		
			_status = STATUS_FLYING;
		}
	}
	// ��ײ��ķ����Ƕ�
	public void reflect(int angle){
		switch(angle){
		case CollisionDetectableEntity.HORIZONTAL:
			_direction = _direction > 180 ? 540 - _direction : 180 - _direction;
			break;
		case CollisionDetectableEntity.VERTICAL:
			_direction = 360 - _direction;
			break;
		}
		_hits++;
		speedUpByHits();
	}
	
	private void speedUpByHits(){
		if(_speed == SPEED_NORMAL && _hits > HITS_TO_HIGH){
			_speed = SPEED_HIGH;
			_hits = 0;
			return;
		}
		if(_speed == SPEED_SLOW && _hits > HITS_TO_NORMAL){
			_speed = SPEED_NORMAL;
			_hits = 0;
			return;
		}
		
	}
	
	public void move(){		
		_x += _speed * Math.sin(Math.toRadians(_direction));
		_y -= _speed * Math.cos(Math.toRadians(_direction));
	}
	
	// getters and setters

	public void set_status(int _status) {
		this._status = _status;
	}

	public int get_status() {
		return _status;
	}

	public void set_direction(int _move_direction) {
		this._direction = _move_direction;
	}

	public int get_direction() {
		return _direction;
	}

	public void set_speed(double _move_speed) {
		this._speed = _move_speed;
	}

	public double get_speed() {
		return _speed;
	}

		
}
