package com.designbirds;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RxJavaVsWorkStealingPoolExample {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> numbers = IntStream.range(1, 1000).boxed().collect(Collectors.toList());
        System.out.println("Starting Java Concurrency Library");
        System.out.printf("Result : %s", squareJavaConcurrency(numbers));

        System.out.println("----------------------------");
        System.out.println("Starting JavaRX Library");
        System.out.printf("Result : %s", squareJavaRx(numbers));

        System.out.println("----------------------------");
        System.out.println("Starting squareJavaStreamsApi");
        System.out.printf("Result : %s", squareJavaStreamsApi(numbers));
    }

    private static List<Integer> squareJavaConcurrency(List<Integer> input) throws InterruptedException {

        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newWorkStealingPool();
        List<Callable<Integer>> callables = new ArrayList<>();

        for (Integer number : input) {
            Callable<Integer> task = () -> {
                return getDetailsPrintedAndReturnResult(number);
            };
            callables.add(task);
        }

        List<Integer> results = new ArrayList<>();
        executorService.invokeAll(callables)
                .stream().map(future -> {
            try {
                return future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).forEach(results::add);

        long end = System.currentTimeMillis();
        System.out.printf("Time Taken  is %s", end - start);
        return results;
    }


    private static List<Integer> squareJavaRx(List<Integer> input) {

        long start = System.currentTimeMillis();
        List<Integer> results = new ArrayList<>();
        Observable.fromIterable(input)
                .flatMap(n -> Observable.just(n)
                        .map(number -> {
                            return getDetailsPrintedAndReturnResult(number);
                        }).subscribeOn(Schedulers.io())).blockingSubscribe(results::add);

        long end = System.currentTimeMillis();
        System.out.printf("Time Taken  is %s", end - start);

        return results;
    }

    public static List<Integer> squareJavaStreamsApi(List<Integer> input) {

        long start = System.currentTimeMillis();
        List<Integer> results = input.parallelStream().map(number -> {
            try {
                return getDetailsPrintedAndReturnResult(number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.printf("Time Taken  is %s", end - start);

        return results;
    }

    private static Integer getDetailsPrintedAndReturnResult(Integer number) throws InterruptedException {
     //   System.out.printf("Processing item %d on thread %s%n", number, Thread.currentThread().getName());
        Thread.sleep(10);
        return number * number;
    }
}
