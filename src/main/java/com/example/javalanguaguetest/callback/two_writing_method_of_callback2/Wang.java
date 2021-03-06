package com.example.javalanguaguetest.callback.two_writing_method_of_callback2;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2020/12/31 2:34 上午
 */
public class Wang implements Li.CallBack {
    Li li;

    public Wang(Li li) {
        this.li = li;
    }

    public void askQuestion(final int num) {

//        异步方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                li.setCallBack(new Li.CallBack() {
                    @Override
                    public void solve(String result) {
                        System.out.println("得到了答案：" + result);
                    }
                });
                li.executeMessage(num);
            }
        }).start();

        goPlay();
    }


    private void goPlay() {
        System.out.println("问完问题，答案未知，玩去了。。。");
    }

    @Override
    public void solve(String result) {

    }
}
