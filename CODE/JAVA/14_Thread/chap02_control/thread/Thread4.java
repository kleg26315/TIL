package com.kh.example.chap02_control.thread;

public class Thread4 implements Runnable {

	@Override
	public void run() {
		int count = 0;

		while(count < 10 && !Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(1000);
				System.out.println((++count) + "��");
			} catch (InterruptedException e) {
				// InterruptedException�� �߻��ϸ� isInterrupted�� true�� �ǵ� false�� �ʱ�ȭ������
				System.out.println(count + "�ʿ� ī��Ʈ ����");
				Thread.currentThread().interrupt();	// �׷��� �ٽ� true���� �ֱ� ���� �ٽ� interrupt ��Ŵ
			}
		}
	}

}
