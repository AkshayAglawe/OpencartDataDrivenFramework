package com.opencart.util;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.opencart.tests.BaseClass;


	public class Listeners extends BaseClass implements ITestListener  {

		@Override
		public void onTestStart(ITestResult result) {
			System.out.println(result.getName() + "-- Started");
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			System.out.println(result.getName() + "-- Succesfully Executed");
		}

		@Override
		public void onTestFailure(ITestResult result) {
			System.out.println(result.getName() + "-- Failed");
			try {
				captureScreenshot(result.getName());
			} catch (IOException e) {

				e.printStackTrace();
			}
			System.out.println("Captured Screenshot");

		}

		@Override
		public void onTestSkipped(ITestResult result) {
			System.out.println(result.getName() + "-- Got skipped");
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		}

		@Override
		public void onTestFailedWithTimeout(ITestResult result) {

		}

		@Override
		public void onStart(ITestContext context) {

		}

		@Override
		public void onFinish(ITestContext context) {

		}


}
