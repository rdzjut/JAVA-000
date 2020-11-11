import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ������ҵ����������˼���ж����ַ�ʽ����main��������һ�����̻߳��̳߳أ�
 * �첽����һ���������õ���������ķ���ֵ���˳����̣߳�
 * д����ķ�����Խ��Խ�ã��ύ��github��
 * <p>
 * һ���򵥵Ĵ���ο���
 */
public class UseCyclicBarrier {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        long start = System.currentTimeMillis();

        // �����ﴴ��һ���̻߳��̳߳�
        // �첽ִ�� ���淽��
        AtomicInteger result = new AtomicInteger();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, () -> new Thread(() -> {
            result.set(sum()); //���ǵõ��ķ���ֵ
        }).start());
        cyclicBarrier.await();

        // ȷ��  �õ�result �����
        System.out.println("�첽������Ϊ��" + result);
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