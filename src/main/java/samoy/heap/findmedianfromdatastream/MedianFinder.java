package samoy.heap.findmedianfromdatastream;

import java.util.PriorityQueue;

/**
 * @link <a href="https://leetcode.cn/problems/find-median-from-data-stream/description/?envType=study-plan-v2&envId=top-100-liked">数据流的中位数</a>
 */
class MedianFinder {
    PriorityQueue<Integer> queueMin, queueMax;

    public MedianFinder() {
        queueMin = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        queueMax = new PriorityQueue<>((a, b) -> (b - a)); // 大顶堆，保存较小的一半
    }

    public void addNum(int num) {
        if (queueMin.size() != queueMax.size()) {
            queueMin.add(num);
            queueMax.add(queueMin.poll());
        } else {
            queueMax.add(num);
            queueMin.add(queueMax.poll());
        }
    }

    public double findMedian() {
        if (queueMin.isEmpty()) {
            throw new RuntimeException();
        }
        return queueMin.size() != queueMax.size() ? queueMin.peek() : (queueMin.peek() + queueMax.peek()) / 2.0;
    }
}
