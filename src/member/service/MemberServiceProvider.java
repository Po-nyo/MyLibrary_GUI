//package member.service;
//
//import member.dao.MemberDAO;
//
//public class MemberServiceProvider {
//    // 필드
//    private MemberRegister memberRegister;
//    private MemberModify memberModify;
//    private MemberDelete memberDelete;
//    private MemberSearch memberSearch;
//
//    // 생성자
//    public MemberServiceProvider(MemberDAO memberDAO) {
//        this.memberRegister = new MemberRegister(memberDAO);
//        this.memberModify = new MemberModify(memberDAO);
//        this.memberDelete = new MemberDelete(memberDAO);
//        this.memberSearch = new MemberSearch(memberDAO);
//    }
//
//    public MemberRegister getMemberRegister() {
//        return memberRegister;
//    }
//
//    public MemberModify getMemberModify() {
//        return memberModify;
//    }
//
//    public MemberDelete getMemberDelete() {
//        return memberDelete;
//    }
//
//    public MemberSearch getMemberSearch() {
//        return memberSearch;
//    }
//}
