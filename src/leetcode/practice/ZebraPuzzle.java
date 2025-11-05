package leetcode.practice;

import java.util.*;

public class ZebraPuzzle {

	static class Residence {
		int shade, resident, beverage, animal, snack;

		public Residence() {
			this.shade = this.resident = this.beverage = this.animal = this.snack = -1;
		}
	}

	static final int TOTAL_RESIDENCES = 5;

	public static void main(String[] args) {
		ZebraPuzzle riddle = new ZebraPuzzle();
		Map<String, Integer> outcome = riddle.solveRiddle();

		if (outcome != null) {
			System.out.println("The zebra resides in house " + outcome.get("zebraResidence"));
			System.out.println("Water is consumed in house " + outcome.get("waterResidence"));
		} else {
			System.out.println("No valid solution found.");
		}
	}

	public Map<String, Integer> solveRiddle() {
		Residence[] residences = new Residence[TOTAL_RESIDENCES];
		for (int i = 0; i < TOTAL_RESIDENCES; i++) {
			residences[i] = new Residence();
		}

		if (findSolution(residences, 0)) {
			int zebraResidence = -1, waterResidence = -1;
			for (int i = 0; i < TOTAL_RESIDENCES; i++) {
				if (residences[i].animal == 4)
					zebraResidence = i + 1;
				if (residences[i].beverage == 0)
					waterResidence = i + 1;
			}
			Map<String, Integer> result = new HashMap<>();
			result.put("zebraResidence", zebraResidence);
			result.put("waterResidence", waterResidence);
			return result;
		}
		return null;
	}

	private boolean findSolution(Residence[] residences, int currentIndex) {
		if (currentIndex == TOTAL_RESIDENCES) {
			return verifySolution(residences);
		}

		for (int shade = 0; shade < TOTAL_RESIDENCES; shade++) {
			for (int resident = 0; resident < TOTAL_RESIDENCES; resident++) {
				for (int beverage = 0; beverage < TOTAL_RESIDENCES; beverage++) {
					for (int animal = 0; animal < TOTAL_RESIDENCES; animal++) {
						for (int snack = 0; snack < TOTAL_RESIDENCES; snack++) {
							residences[currentIndex].shade = shade;
							residences[currentIndex].resident = resident;
							residences[currentIndex].beverage = beverage;
							residences[currentIndex].animal = animal;
							residences[currentIndex].snack = snack;

							if (isPartiallyValid(residences, currentIndex)
									&& findSolution(residences, currentIndex + 1)) {
								return true;
							}
						}
					}
				}
			}
		}

		return false;
	}

	private boolean isPartiallyValid(Residence[] residences, int currentIndex) {
		for (int i = 0; i <= currentIndex; i++) {
			for (int j = i + 1; j <= currentIndex; j++) {
				if (!areUnique(residences[i], residences[j])) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean areUnique(Residence res1, Residence res2) {
		return res1.shade != res2.shade && res1.resident != res2.resident && res1.beverage != res2.beverage
				&& res1.animal != res2.animal && res1.snack != res2.snack;
	}

	private boolean verifySolution(Residence[] residences) {
		if (residences[0].resident != 0)
			return false;

		if (!checkCondition(residences, (res) -> res.resident == 1 && res.shade == 2))
			return false;

		for (int i = 0; i < TOTAL_RESIDENCES - 1; i++) {
			if (residences[i].shade == 3 && residences[i + 1].shade != 4)
				return false;
		}

		if (residences[2].beverage != 2)
			return false;

		if (!checkCondition(residences, (res) -> res.beverage == 3 && res.shade == 4))
			return false;

		return true;
	}

	private boolean checkCondition(Residence[] residences, java.util.function.Predicate<Residence> predicate) {
		for (Residence residence : residences) {
			if (predicate.test(residence)) {
				return true;
			}
		}
		return false;
	}
}
