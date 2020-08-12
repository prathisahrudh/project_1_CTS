package voter;

import java.util.List;

public interface voterService 
{
	int addVoter(Voter v);
	List<Voter> getAll();
	int UpdateVote(Voter v);
}
