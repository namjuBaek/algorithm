package hash;

import java.util.Arrays;
/*
<�������� ���� ����>
�� �� ���� ������ �����ϰ�� ��� ������ �������� �����ߴ�.
�����濡 ������ �������� �̸��� ��� �迭 participant�� 
������ �������� �̸��� ��� �迭 completion�� �־��� ��, 
�������� ���� ������ �̸��� ���ؾ� �Ѵ�.
*/

public class hash4 {
    public static void main(String[] args) {
        String result;
        
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        
        result = solution(participant, completion);
        
        System.out.print(result);
    }

    public static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int i=0;
        for (i=0; i<completion.length; i++) {
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }
                
        return participant[i];
    }
}

/**
 * 2021.09.11
 * �ؽ� 1�ܰ� ������ ����Ʈ �ٹ��� Ǯ����.
 * 2, 3�ܰ�� Ǯ����� 1�ܰ�� ��Ǯ����淡 ������ Ǯ��ô�.
 * ó������ ��ü ��ȸ�ϴ� ������� �ۼ��ߴµ�, ȿ���� �׽�Ʈ���� ��������
 * ������ �Ŀ� ���ϴ� ������� �õ��ߴ�.
 * hash ī�װ��� �ִ� �����̱� ������ hash ����ؼ� �ۼ��ϴ� ����� ����غ��߰ڴ�.
 */