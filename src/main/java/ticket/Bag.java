package ticket;

public class Bag {
	private Long amount;
	private Invitation invitation;
	private Ticket ticket;

	public Bag(Long amount) {
		this(null, amount);
	}

	public Bag(Invitation invitation, Long amount) {
		this.invitation = invitation;
		this.amount = amount;
	}

	public Long hold(Ticket ticket) {
		setTicket(ticket);
		if (hasInvitation()) {
			return 0L;
		}

		Long fee = ticket.getFee();
		minusAmount(fee);
		return fee;
	}

	private boolean hasInvitation() {
		return invitation != null;
	}

	private void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	private void minusAmount(Long amount) {
		this.amount -= amount;
	}

}
