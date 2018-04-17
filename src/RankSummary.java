import java.math.BigInteger;
import java.util.Comparator;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 输入格式：输入的第一行给出一个正整数N（≤100），代表考点总数。随后给出N个考点的成绩，格式为：首先一行给出正整数K（≤300），代表该考点的考生总数；
 * 随后K行，每行给出1个考生的信息，包括考号（由13位整数字组成）和得分（为[0,100]区间内的整数），中间用空格分隔。
 *
 *输出格式: 首先在第一行里输出考生总数。
 * 随后输出汇总的排名表，每个考生的信息占一行，顺序为：考号、最终排名、考点编号、在该考点的排名。
 * 其中考点按输入给出的顺序从1到N编号。
 * 考生的输出须按最终排名的非递减顺序输出，获得相同分数的考生应有相同名次，并按考号的递增顺序输出。
 * Created by 没想法的岁月 on 2018/4/16.
 * development 分支22342342K
 */
public class RankSummary {
    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>(new RankComparator());
        imput(1,5,"1234567890001 95,1234567890005 100,1234567890003 95,1234567890002 77,1234567890004 85",treeSet);
        imput(2,4,"1234567890013 65,1234567890011 25,1234567890014 100,1234567890012 85",treeSet);
        Student[] stArray = treeSet.toArray(new Student[9]);
        System.out.println("考生的总数为"+ stArray.length);
        for (int i = 0; i < treeSet.size(); i++) {
            System.out.println("学生考号为 "+ stArray[i].getId()+" 最终排名"+ (i + 1) + " 所在考场"+stArray[i].getLocation()+" 所在考场内排名为"+getRankLocal(stArray[i]));
        }
    }

    /**
     *
     * @param student
     * @return  学生在对应考场下的排名信息
     */
    private static int getRankLocal(Student student) {
        if (student.getLocation() == 1) {
            TreeSet<Student> treeSet1 = new TreeSet<>(new RankComparator());
            imput(1,5,"1234567890001 95,1234567890005 100,1234567890003 95,1234567890002 77,1234567890004 85",treeSet1);
            Student[] stArray1 = treeSet1.toArray(new Student[5]);
            for (int i = 0; i < treeSet1.size(); i++) {
                if (stArray1[i].equals(student)) {
                    return i + 1;
                }
            }
        } else {
            TreeSet<Student> treeSet2 = new TreeSet<>(new RankComparator());
            imput(2,4,"1234567890013 65,1234567890011 25,1234567890014 100,1234567890012 85",treeSet2);
            Student[] stArray2 = treeSet2.toArray(new Student[4]);
            for (int i = 0; i < treeSet2.size(); i++) {
                if (stArray2[i].equals(student)) {
                    return i + 1;
                }
            }
        }
        return 0;
    }

    /**
     *
     * @param n 考场总数
     * @param k 几行数据信息
     * @param strings 学生信息
     * @param treeSet 进行排序用的set集合
     *  功能：获得一个含有学生信息的treeSet集合
     */
    private static void imput(int n,int k, String strings,TreeSet<Student> treeSet) {
        String[] split = strings.split(",");
        for (String st :split
                ) {
            String[] split1 = st.split(" ");
             treeSet.add(new Student(n, BigInteger.valueOf(Long.parseLong(split1[0])), Integer.parseInt(split1[1])));
        }
    }
}

/**
 * 排序：考生的输出须按最终排名的非递减顺序输出，获得相同分数的考生应有相同名次，并按考号的递增顺序输出。
 */
class RankComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        int i = o1.getSource()-o2.getSource();
        if (i > 0) {
            return -1;
        } else if (i < 0) {
            return 1;
        } else {
            int k = o1.getId().intValue() -o2.getId().intValue();
            if (k > 0) {
                return 1;
            } else if (k < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
