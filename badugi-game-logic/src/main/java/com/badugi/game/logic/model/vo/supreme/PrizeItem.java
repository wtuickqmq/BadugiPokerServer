package com.badugi.game.logic.model.vo.supreme;

public enum PrizeItem {
		 MINVW("minVW"),MINBMW("minBMW"),MINBENZ("minBenz"),MINPORSCHE("minPorsche"),
		 BIGVW("bigVW"),BIGBMW("bigBMW"),BIGBENZ("bigBenz"),BIGPORSCHE("bigPorsche"),SUMCHIPS("sumchips");
	     private String item;
		 PrizeItem(){}
		 PrizeItem(String item){
			this.item = item;
		}
		public String getItem() {
			return item;
		}
		public void setItem(String item) {
			this.item = item;
		}
		
	}

