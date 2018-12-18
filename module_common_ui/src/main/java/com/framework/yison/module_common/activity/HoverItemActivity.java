package com.framework.yison.module_common.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.framework.yison.module_common.R;
import com.framework.yison.module_common.adapter.HoverAdapter;
import com.framework.yison.module_common.bean.HoverItemBean;
import com.framework.yison.module_common.utils.CharacterParser;
import com.framework.yison.module_common.utils.PinyinComparator;
import com.framework.customview.widget.HoverItemDecoration;
import com.framework.customview.widget.IndexView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *吸顶效果
 * 类似电话本样式
 * 更多自定义效果: https://github.com/lygttpod/AndroidCustomView
 */

public class HoverItemActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private IndexView indexView;
    private TextView showTextDialog;

    private HoverAdapter adapter;

    private List<HoverItemBean> userBeans = new ArrayList<>();

    private String[] names = new String[]{"阿妹", "打黑牛", "张三", "李四", "王五", "田鸡", "孙五"};

    /**
     * 汉字转换成拼音的类
     */
    private CharacterParser characterParser;
    /**
     * 根据拼音来排列ListView里面的数据类
     */
    private PinyinComparator pinyinComparator;

    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hover_item);

        characterParser = CharacterParser.getInstance();
        pinyinComparator = new PinyinComparator();


        userBeans = filledData(getData());

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        indexView = (IndexView) findViewById(R.id.index_view);
        showTextDialog = (TextView) findViewById(R.id.show_text_dialog);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //一行代码实现吸顶悬浮的效果
        recyclerView.addItemDecoration(new HoverItemDecoration(this, new HoverItemDecoration.BindItemTextCallback() {
            @Override
            public String getItemText(int position) {
                //悬浮的信息
                return userBeans.get(position).getSortLetters();
            }
        }));

        adapter = new HoverAdapter(userBeans);

        recyclerView.setAdapter(adapter);

        initIndexView();
    }

    /**
     * 初始化右边字幕索引view
     */
    private void initIndexView() {
        indexView.setShowTextDialog(showTextDialog);
        indexView.setOnTouchingLetterChangedListener(new IndexView.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String letter) {
                // 该字母首次出现的位置
                int position = getPositionForSection(letter);
                if (position != -1) {
                    layoutManager.scrollToPositionWithOffset(position, 0);
                    layoutManager.setStackFromEnd(false);
                }
            }
        });
    }

    public int getPositionForSection(String section) {
        for (int i = 0; i < userBeans.size(); i++) {
            String sortStr = userBeans.get(i).getSortLetters();
            if (sortStr.equals(section)) {
                return i;
            }
        }
        return -1;
    }

    private List<HoverItemBean> getData() {
        List<HoverItemBean> userBeans = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            HoverItemBean userBean = new HoverItemBean();
            userBean.setUserName(names[i % 7]);
            userBeans.add(userBean);
        }

        return userBeans;
    }

    private List<HoverItemBean> filledData(List<HoverItemBean> sortList) {

        for (int i = 0; i < sortList.size(); i++) {

            if ("".equals(sortList.get(i).getUserName())) {
                sortList.get(i).setSortLetters("#");
            } else {
                // 汉字转换成拼音
                String pinyin = characterParser.getSelling(sortList.get(i).getUserName());
                String sortString = pinyin.substring(0, 1).toUpperCase();

                // 正则表达式，判断首字母是否是英文字母
                if (sortString.matches("[A-Z]")) {
                    sortList.get(i).setSortLetters(sortString.toUpperCase());
                } else {
                    sortList.get(i).setSortLetters("#");
                }
            }

        }

        // 根据a-z进行排序源数据
        Collections.sort(sortList, pinyinComparator);

        return sortList;
    }

}
