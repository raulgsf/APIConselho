package io.code.myapi.dominio;

public class Conselho {
	Slip slip;
	
	public class Slip {
		String id;
		String advice;
		public String getId() {
			return id;
		}
		public String getAdvice() {
			return advice;
		}

	}

	public Slip getSlip() {
		return slip;
	}

	@Override
	public String toString() {
		return "Conselho [slip=" + slip + "]";
	}

	
}