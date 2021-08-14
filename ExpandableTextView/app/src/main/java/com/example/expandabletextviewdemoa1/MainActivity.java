package com.example.expandabletextviewdemoa1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView view = (TextView) findViewById(R.id.text);
        String text = (String) view.getText();
        //int maxLine = (int) view.getMaxLines();

        setReadMore readMore = new setReadMore(view, text, 2);
    }

    private class setReadMore {
        public setReadMore(final TextView view, final String text, final int maxLine) {

            final Context context = view.getContext();
            final String expanedText = " ... 더보기";

            if (view.getTag() != null && view.getTag().equals(text)) { //Tag로 전값 의 text를 비교하여똑같으면 실행하지 않음.
                return;
            }
            view.setTag(text); //Tag에 text 저장
            view.setText(text); // setText를 미리 하셔야  getLineCount()를 호출가능
            view.post(new Runnable() { //getLineCount()는 UI 백그라운드에서만 가져올수 있음
                @Override
                public void run() {
                    if (view.getLineCount() >= maxLine) { //Line Count가 설정한 MaxLine의 값보다 크다면 처리시작

                        int lineEndIndex = view.getLayout().getLineVisibleEnd(maxLine - 1); //Max Line 까지의 text length

                        String[] split = text.split("\n"); //text를 자름
                        int splitLength = 0;

                        String lessText = "";
                        for (String item : split) {
                            splitLength += item.length() + 1;
                            if (splitLength >= lineEndIndex) { //마지막 줄일때!
                                if (item.length() >= expanedText.length()) {
                                    lessText += item.substring(0, item.length() - (expanedText.length())) + expanedText;
                                } else {
                                    lessText += item + expanedText;
                                }
                                break; //종료
                            }
                            lessText += item + "\n";
                        }
                        SpannableString spannableString = new SpannableString(lessText);
                        spannableString.setSpan(new ClickableSpan() {//클릭이벤트
                            @Override
                            public void onClick(View v) {
                                view.setText(text);
                            }

                            @Override
                            public void updateDrawState(TextPaint ds) { //컬러 처리
                                ds.setColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
                            }
                        }, spannableString.length() - expanedText.length(), spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                        view.setText(spannableString);
                        view.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                }
            });
        }
    }
}
