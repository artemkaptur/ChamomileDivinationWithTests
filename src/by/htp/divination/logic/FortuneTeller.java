package by.htp.divination.logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

import by.htp.divination.bean.Chamomile;

public class FortuneTeller {
	private String nickName;
	private LinkedList<Chamomile> chamomiles;
	private int chamomilesCount;
	private Set<Client> clients;
	private Map<String, String[]> divinations;
	private Date currentDate;

	public FortuneTeller() {
		super();
		clients = new HashSet<>();
		createChamomiles();
		createDivinations();
		currentDate = new Date();
	}

	public FortuneTeller(String nickName) {
		super();
		this.nickName = nickName;
		clients = new HashSet<>();
		createChamomiles();
		createDivinations();
		currentDate = new Date();

	}

	private void createChamomiles() {
		chamomilesCount = (int) (Math.random() * 5 + 1);
		chamomiles = new LinkedList<>();
		for (int i = 1; i <= chamomilesCount; i++) {
			chamomiles.add(new Chamomile());
		}
	}

	private void createDivinations() {
		divinations = new HashMap<>();
		divinations.put(new String("Money"), new String[] { "Become the second Bill Gates", "Become homeless",
				"Be corporate clerk your entire life" });
		divinations.put(new String("Love"), new String[] { "Scarlett Johansson will be your girlfriend",
				"Brad Pitt will be your boyfrend", "You'll live with mom your entire life " });
		divinations.put(new String("Health"),
				new String[] { "You'll live 500 years", "You'll live 80 years", "Uhps, time is over" });
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public LinkedList<Chamomile> getChamomiles() {
		return chamomiles;
	}

	public void setChamomiles(LinkedList<Chamomile> chamomiles) {
		this.chamomiles = chamomiles;
	}

	public int getChamomilesCount() {
		return chamomilesCount;
	}

	public void setChamomilesCount(int chamomilesCount) {
		this.chamomilesCount = chamomilesCount;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(HashSet<Client> clients) {
		this.clients = clients;
	}

	public Map<String, String[]> getDivinations() {
		return divinations;
	}

	public void setDivinations(HashMap<String, String[]> divinations) {
		this.divinations = divinations;
	}

	@Override
	public String toString() {
		return "FortuneTeller [nickName=" + nickName + ", chamomiles=" + chamomiles + ", clients=" + clients
				+ ", divinations=" + divinations + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chamomiles == null) ? 0 : chamomiles.hashCode());
		result = prime * result + chamomilesCount;
		result = prime * result + ((clients == null) ? 0 : clients.hashCode());
		result = prime * result + ((currentDate == null) ? 0 : currentDate.hashCode());
		result = prime * result + ((divinations == null) ? 0 : divinations.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FortuneTeller other = (FortuneTeller) obj;
		if (chamomiles == null) {
			if (other.chamomiles != null)
				return false;
		} else if (!chamomiles.equals(other.chamomiles))
			return false;
		if (chamomilesCount != other.chamomilesCount)
			return false;
		if (clients == null) {
			if (other.clients != null)
				return false;
		} else if (!clients.equals(other.clients))
			return false;
		if (currentDate == null) {
			if (other.currentDate != null)
				return false;
		} else if (!currentDate.equals(other.currentDate))
			return false;
		if (divinations == null) {
			if (other.divinations != null)
				return false;
		} else if (!divinations.equals(other.divinations))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		return true;
	}

	public String makeDivination(Client client) {
		checkDate();
		try {
			if (!clients.contains(client)) {
				clients.add(client);
				String answer = makingDivination();
				return answer;
			} else
				return "Sorry buddy, I have already told your future, come back tommorow!\n";
		} catch (NoSuchElementException e) {
			return "Sorry my magic power ended (I have no chamomiles)...\n";
		}
	}

	private void checkDate() {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		if (!df.format(currentDate).equals(df.format(new Date()))) {
			clients.clear();
		}
	}

	private String makingDivination() {
		String[] futureVariants = getVariantsOfDivination();
		int petalsCount = chamomiles.getFirst().getPetalsCount();
		try {
			for (int i = 1; i < futureVariants.length; i++) {
				if (petalsCount % futureVariants.length != 0) {
					if (petalsCount % futureVariants.length == i) {
						chamomiles.remove();
						return futureVariants[i - 1];
					}
				} else {
					chamomiles.remove();
					return futureVariants[futureVariants.length - 1];
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Something went wrong in getVariantsOfDivination method");
			e.printStackTrace();
		}
		return null;
	}

	private String[] getVariantsOfDivination () {
		ArrayList<String> arr = new ArrayList<>();
		for (Map.Entry<String, String[]> divination : divinations.entrySet()) {
			arr.add(divination.getKey());
		}
		String divination=chooseDivination(arr);
		for (int i = 0; i < arr.size(); i++) {
			if (divination.equals(arr.get(i)))
				return divinations.get(arr.get(i));
		}
		return null;
	}

	@SuppressWarnings("resource")
	private String chooseDivination(ArrayList<String> arr) {
		String s;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Choose topic of divinations: " + arr);
			s = sc.next();
		} while (!arr.contains(s));
		return s;
	}

}
