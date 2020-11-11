import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ������ҵ����������˼���ж����ַ�ʽ����main��������һ�����̻߳��̳߳أ�
 * �첽����һ���������õ���������ķ���ֵ���˳����̣߳�
 * д����ķ�����Խ��Խ�ã��ύ��github��
 * <p>
 * һ���򵥵Ĵ���ο���
 */
public class UseFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();

        // �����ﴴ��һ���̻߳��̳߳�
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // �첽ִ�� ���淽��
        Future<Integer> result = executorService.submit(() -> {
            return sum();//���ǵõ��ķ���ֵ });
                });

        // ȷ��  �õ�result �����
        System.out.println("�첽������Ϊ��"+result);

        System.out.println("ʹ��ʱ�䣺"+ (System.currentTimeMillis()-start) + " ms");

        // Ȼ���˳�main�߳�
        executorService.shutdown();
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