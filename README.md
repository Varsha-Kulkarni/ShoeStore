# Shoe Store - Inventory app

This app is developed as part of Udacity Nanodegree Android Kotlin Developer Course. This is useful in managing Shoe inventory.


The project consists of following screens:

Login screen: Email and password fields (using com.google.android.material.textfield.TextInputLayout, Material Design Library) and 
<com.google.android.material.button.MaterialButton> for Login and Signup buttons.

Welcome onboarding screen: Two TextViews and Next Button to go to the next screen.

Instructions onboarding screen: Two TextViews instructing about the next screen and Next Button to navigate to the next screen.

Shoe Listing screen: A LinearLayout inside the ScrollView for Shoe Items and a FloatingActionButton with an action to navigate to the shoe
detail screen

Shoe Detail screen for adding a new shoe: A layout with fields (using com.google.android.material.textfield.TextInputLayout, Material Design Library)
to enter Shoe Name, Brand, Shoe Size and Description. 
A Cancel button with an action to navigate back to the shoe list screen
A Save button with an action to navigate back to the shoe list screen and add a new Shoe to the Shoe View Model using 
<com.google.android.material.button.MaterialButton>

The shoe listing page shows the list of shoes and show a button for adding a new shoe, while the detail page is for adding a shoe entry. 
All entries are saved only as long as the app is running.

## Rubric Followed
The Detail screen to add the new item to the view model. The listing screen is listening to the model and show the new item.
There is one activity: MainActivity. All other screens are fragments.
The project code is error-free.

The project is created with layouts using the correct ViewGroups and Views in an Android app.

The Databinding is applied in Layouts to show the correct data to users in multiple layouts.
The <data> and <variable> elements are correctly used within the layouts.

The List screen is using ScrollView and LinearLayout for showing a list of items and one Floating Action button for going to the detail screen 
and it creates a layout for the item inserted in the detail screen.

The detail screen shows edit fields to enter in a new item. It uses data binding to save data and a save button to save data to view model

The project is created with a navigation file with start destination and all the destinations have a fragment, label and action associated with them.
This is correctly taking a user from one page to the next in the following order:

Login
Welcome
Instructions screen
Listing screen
Detail screen
The app is able to navigate back via the back arrow or the back button. 
The login and onboarding pages are not shown again when Back pressed on ShoeList screen.

The Logout menu is created to return to the Login screen.This menu appears only on the Shoe Listing screen and returns the user to the login screen.

## To do
Errors in the fields when orientation changes.

Images for Shoe Model.


