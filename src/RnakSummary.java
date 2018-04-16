import java.util.HashMap;

/**
 * 输入格式：输入的第一行给出一个正整数N（≤100），代表考点总数。随后给出N个考点的成绩，格式为：首先一行给出正整数K（≤300），代表该考点的考生总数；
 * 随后K行，每行给出1个考生的信息，包括考号（由13位整数字组成）和得分（为[0,100]区间内的整数），中间用空格分隔。
 *
 *输出格式: 首先在第一行里输出考生总数。
 * 随后输出汇总的排名表，每个考生的信息占一行，顺序为：考号、最终排名、考点编号、在该考点的排名。
 * 其中考点按输入给出的顺序从1到N编号。
 * 考生的输出须按最终排名的非递减顺序输出，获得相同分数的考生应有相同名次，并按考号的递增顺序输出。
 * Created by 没想法的岁月 on 2018/4/16.
 */
public class RnakSummary {
    public static void main(String[] args) {
        imput(5,"1234567890001 95,1234567890005 100,1234567890003 95,1234567890002 77,1234567890004 85");
    }

    private static void imput(int i, String strings) {
        HashMap<String,String> hashMap = new HashMap(i);
        HashMap<String,String> newhashMap = new HashMap(i);
        String[] split = strings.split(",");
        for (String st :split
                ) {
            String[] split1 = st.split(" ");
            for (int j = 0; j < split1.length; j++) {
                hashMap.put(split1[1], split1[0]);
                newhashMap.put(split1[0], split1[1]);
            }
        }
        hashMap.keySet();

    }


}
