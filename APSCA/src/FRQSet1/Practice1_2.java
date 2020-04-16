package FRQSet1;

public class Practice1_2 {
public class BatteryCharger {
		
		private int[] rateTable = {50,60,160,60,80,100,100,120,150,150,150,200,40
				,240,220,220,200,200,180,180,140,100,80,60};
		
		private int getChargingCost(int startHour, int chargingTime) {
			int cost = 0;
			int k = startHour;
			for(int i = startHour; i < startHour + chargingTime; i++) {
				cost+=rateTable[k];
				k++;
				if(k > 23) {
					k=0;
				}
			}
			return cost;
		}
		
		public int getChargeStartTime(int chargeTime) {
			int startTime = 0;
			int cheapestCost = getChargingCost(0, chargeTime);
			for(int i=0; i<24; i++) {
				if(getChargingCost(i, chargeTime) < cheapestCost) {
					startTime = i;
				}
			}
			return startTime;
		}
	}
}
