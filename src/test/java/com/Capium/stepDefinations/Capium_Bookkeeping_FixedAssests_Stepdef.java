package com.Capium.stepDefinations;

import com.Capium.Actions.Capium_Bookkeeping_FixedAssets_Actions;
import com.Capium.Utilies.Log;
import com.Capium.Utilies.StepTracker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Capium_Bookkeeping_FixedAssests_Stepdef {

	Capium_Bookkeeping_FixedAssets_Actions FixedAssestActions = new Capium_Bookkeeping_FixedAssets_Actions();
	
		@Given("Click onfixedassests validate fixedassests page")
		public void click_onfixedassests_validate_fixedassests_page() throws InterruptedException {
	 
			FixedAssestActions.Clickonfixedassestsvalidatefixedassestspage();
	 
			StepTracker.setCurrentStep("Click onfixedassests validate fixedassests page");
			Log.info("Click onfixedassests validate fixedassests page");
		}
	 
		@Then("Click on addfixedassests and verify purchase page")
		public void click_on_addfixedassests_and_verify_purchase_page() throws InterruptedException {
	 
			FixedAssestActions.Clickonaddfixedassestsandverifypurchasepage();
	 
			StepTracker.setCurrentStep("Click on addfixedassests and verify purchase page");
			Log.info("Click on addfixedassests and verify purchase page");
		}
	 
		@Then("Click addfixedassests and add tangble assest in purchase")
		public void click_addfixedassests_and_add_tangble_assest_in_purchase() throws InterruptedException {
	 
			FixedAssestActions.Clickaddfixedassestsandaddtangbleassestinpurchase();
			StepTracker.setCurrentStep("Click addfixedassests and add tangble assest in purchase");
			Log.info("Click addfixedassests and add tangble assest in purchase");
		}
	 
		@Then("Click addfixedassests and add intangble assest in purchase")
		public void click_addfixedassests_and_add_intangble_assest_in_purchase() throws InterruptedException {
	 
			FixedAssestActions.Clickaddfixedassestsandaddintangbleassestinpurchase();
	 
			StepTracker.setCurrentStep("Click addfixedassests and add intangble assest in purchase");
			Log.info("Click addfixedassests and add intangble assest in purchase");
		}
	 
		@Then("Click addfixedassests and add leased assest in purchase")
		public void click_addfixedassests_and_add_leased_assest_in_purchase() throws InterruptedException {
	 
			FixedAssestActions.Clickaddfixedassestsandaddleasedassestinpurchase();
	 
			StepTracker.setCurrentStep("Click addfixedassests and add leased assest in purchase");
			Log.info("Click addfixedassests and add leased assest in purchase");
		}
	 
		@Then("Click on edit and explain in action dropdown for tangible")
		public void click_on_edit_and_explain_in_action_dropdown_for_tangible() throws InterruptedException {
	 
			FixedAssestActions.Clickoneditandexplaininactiondropdownfortangible();
	 
			StepTracker.setCurrentStep("Click on edit and explain in action dropdown for tangible");
			Log.info("Click on edit and explain in action dropdown for tangible");
	 
		}
	 
		@Then("Click on sell in action dropdown for tangible")
		public void click_on_sell_in_action_dropdown_for_tangible() throws InterruptedException {
	 
			FixedAssestActions.Clickonsellinactiondropdownfortangible();
	 
			StepTracker.setCurrentStep("Click on sell in action dropdown for tangible");
			Log.info("Click on sell in action dropdown for tangible");
	 
		}
	 
		@Then("Click on activate\\(sell aseest) in action dropdown for tangible")
		public void click_on_activate_sell_aseest_in_action_dropdown_for_tangible() throws InterruptedException {
	 
			FixedAssestActions.Clickonactivatesellaseestinactiondropdownfortangible();
	 
			StepTracker.setCurrentStep("Click on activate\\\\(sell aseest) in action dropdown for tangible");
			Log.info("Click on activate\\\\(sell aseest) in action dropdown for tangible");
	 
		}
	 
		@Then("Click on disposed in action dropdown for tangble")
		public void click_on_disposed_in_action_dropdown_for_tangble() throws InterruptedException {
	 
			FixedAssestActions.Clickondisposedinactiondropdownfortangible();
			StepTracker.setCurrentStep("Click on disposed in action dropdown for tangble");
			Log.info("Click on disposed in action dropdown for tangble");
	 
		}
	 
		@Then("Click on activate\\(disposed)action dropdown for tangble")
		public void click_on_activate_disposed_action_dropdown_for_tangble() throws InterruptedException {
	 
			FixedAssestActions.Clickonactivatedisposedactiondropdownfortangible();
	 
			StepTracker.setCurrentStep("Click on activate\\\\(disposed)action dropdown for tangble");
			Log.info("Click on activate\\\\(disposed)action dropdown for tangble");
	 
		}
	 
		@Then("Click on edit and explain in action dropdown for intangible")
		public void click_on_edit_and_explain_in_action_dropdown_for_intangible() throws InterruptedException {
	 
			FixedAssestActions.Clickoneditandexplaininationropdownforintangible();
	 
			StepTracker.setCurrentStep("Click on edit and explain in action dropdown for intangible");
			Log.info("Click on edit and explain in action dropdown for intangible");
		}
	 
		@Then("Click on disposed in action dropdown for intangble")
		public void click_on_disposed_in_action_dropdown_for_intangble() throws InterruptedException {
	 
			FixedAssestActions.Clickondisposedinactiondropdownforintangble();
	 
			StepTracker.setCurrentStep("Click on disposed in action dropdown for intangble");
			Log.info("Click on disposed in action dropdown for intangble");
		}
	 
		@Then("Click on activate\\(disposed)action dropdown for intangble")
		public void click_on_activate_disposed_action_dropdown_for_intangble() {
	 
			FixedAssestActions.Clickonactivatedisposedactiondropdownforintangble();
	 
			StepTracker.setCurrentStep("Click on activate\\\\(disposed)action dropdown for intangble");
			Log.info("Click on activate\\\\(disposed)action dropdown for intangble");
	 
		}
	 
		@Then("Click on edit and explain in action dropdown for leased")
		public void click_on_edit_and_explain_in_action_dropdown_for_leased() throws InterruptedException {
	FixedAssestActions.Clickoneditandexplaininactiondropdownforleased();
			StepTracker.setCurrentStep("Click on edit and explain in action dropdown for leased");
			Log.info("Click on edit and explain in action dropdown for leased");
	 
		}
	 
		@Then("Click on sell in action dropdown for leased")
		public void click_on_sell_in_action_dropdown_for_leased() throws InterruptedException {
	 
			FixedAssestActions.Clickonsellinactiondropdownforleased();
	 
			StepTracker.setCurrentStep("Click on sell in action dropdown for leased");
			Log.info("Click on sell in action dropdown for leased");
		}
	 
		@Then("Click on activate\\(sell aseest) in action dropdown for leased")
		public void click_on_activate_sell_aseest_in_action_dropdown_for_leased() {
	 
			FixedAssestActions.Clickonactivatesellaseestinactiondropdownforleased();
	 
			StepTracker.setCurrentStep("Click on activate\\\\(sell aseest) in action dropdown for leased");
			Log.info("Click on activate\\\\(sell aseest) in action dropdown for leased");
	 
		}
	 
		@Then("Click on disposed in action dropdown for leased")
		public void click_on_disposed_in_action_dropdown_for_leased() throws InterruptedException {
	 
			FixedAssestActions.Clickondisposedinactiondropdownforleased();
	 
			StepTracker.setCurrentStep("Click on disposed in action dropdown for leased");
			Log.info("Click on disposed in action dropdown for leased");
	 
		}
	 
		@Then("Click on activate\\(disposed)action dropdown for leased")
		public void click_on_activate_disposed_action_dropdown_for_leased() {
	 
			FixedAssestActions.Clickonactivatedisposedactiondropdownforleased();
	 
			StepTracker.setCurrentStep("Click on activate\\\\(disposed)action dropdown for leased");
			Log.info("Click on activate\\\\(disposed)action dropdown for leased");
	 
		}
	 
		@Then("Click on depreciation and verify depreciate")
		public void click_on_depreciation_and_verify_depreciate() throws InterruptedException {
	 
			FixedAssestActions.Clickondepreciationandverifydepreciate();
	 
			StepTracker.setCurrentStep("Click on depreciation and verify depreciate");
			Log.info("Click on depreciation and verify depreciate");
	 
		}

}
