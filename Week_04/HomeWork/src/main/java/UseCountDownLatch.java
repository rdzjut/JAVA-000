import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ������ҵ����������˼���ж����ַ�ʽ����main��������һ�����̻߳��̳߳أ�
 * �첽����һ���������õ���������ķ���ֵ���˳����̣߳�
 * д����ķ�����Խ��Խ�ã��ύ��github��
 * <p>
 * һ���򵥵Ĵ���ο���
 */
public class UseCountDownLatch {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        // �����ﴴ��һ���̻߳��̳߳�
        // �첽ִ�� ���淽��
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicInteger result = new AtomicInteger();
        new Thread(() -> {
            result.set(sum()); //���ǵõ��ķ���ֵ
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();

        // ȷ��  �õ�result �����
        System.out.println("�첽������Ϊ��" + result.get());
        System.out.println("ʹ��ʱ�䣺" + (System.currentTimeMillis() - start) + " ms");

        // Ȼ���˳�main�߳�
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}