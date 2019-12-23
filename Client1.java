public double bill() {
		double sum = 0;
		for(int i = 0; i < insurance.size(); i++) {
			for(int j = 0; j < Service.services.size(); j++) {
				if(insurance.get(i)[0][0].equals(Service.services.get(j).getId())) {
					if (insurance.get(i)[0][1] == 6) {
						sum = sum + Service.services.get(j).getCost();
					} else {
						sum += Service.services.get(j).getCost() * 1.8;
					}
					break;
				}
			}
		}
		return sum;
	}