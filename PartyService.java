package party;

import java.util.List;

public interface PartyService {
	List<Party> getAll();
	int addParty(Party p);
	int deleteParty(int partyId);
}
