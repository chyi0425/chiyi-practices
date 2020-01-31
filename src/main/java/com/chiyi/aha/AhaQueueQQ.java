package com.chiyi.aha;

public class AhaQueueQQ {
    public static void main(String[] args) {
        int q[] = {0, 6, 3, 1, 7, 5, 8, 9, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int head, tail;
        head = 1;
        tail = 10;
        while (head < tail) {
            System.out.printf("%d ", q[head]);
            // 将队首出队
            head++;

            // 先将新队首的数添加到队尾
            q[tail] = q[head];
            tail++;
            //再将队首出队
            head++;
        }
    }
}
