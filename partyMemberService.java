package partyMember;

import java.util.List;

public interface partyMemberService {
	List<partyMember> getAll();
	int addPartyMember(partyMember pm);
}
