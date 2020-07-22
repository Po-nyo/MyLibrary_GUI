/**
 *
 */

package member.dao;

import member.Member;
import java.util.HashMap;
import java.util.Set;

public class MemberDAO {

    private static HashMap<String, Member> memberDB;


    public MemberDAO() {
        memberDB = new HashMap<String, Member>();           // HashMap 객체 생성
    }

    public void insert(String name, Member member) {
        memberDB.put(name, member);
    }

    public Member search(String name) {
        return memberDB.get(name);
    }

    public void delete(String name) {
        memberDB.remove(name);
    }

    public Set<String> getKeySet() {
        return memberDB.keySet();
    }

}
