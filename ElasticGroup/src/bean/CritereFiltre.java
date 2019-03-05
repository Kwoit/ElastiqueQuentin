package bean;

public class CritereFiltre {

		private String libelle;
		private String requestPart;
		
		public CritereFiltre(String libelle, String requestPart) {
			super();
			this.libelle = libelle;
			this.requestPart = requestPart;
		}

		public String getLibelle() {
			return libelle;
		}

		public String getRequestPart() {
			return requestPart;
		}

		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}

		public void setRequestPart(String requestPart) {
			this.requestPart = requestPart;
		}
		
		
}
