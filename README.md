# Access Control System (ACS) Prototype

This is the repository for the Access Control System (ACS) prototype project. This is a university project aimed at demonstrating the principles of object-oriented design, applying necessary design patterns, learning good programming practices, and applying some user experience research and design techniques.

## Description

An ACS is a form of physical security that manages who has access to a specific area at any given time. Access control systems restrict access to authorized users and provide a means to keep track of who enters and leaves secured areas.

This project includes the implementation of electrified doors, turnstiles, guards, and gates to keep an area secure. In an access-controlled building, authorized persons use credentials (physical, digital via a mobile device, or biometric) to make unlock requests at readers, which send information to an Access Control Unit (ACU). The ACU then triggers the electrified door hardware to unlock if authorized.

## Features

Modern ACS have the following key characteristics:

1. They can work with credentials embedded in smartphones.
2. The ACU is cloud-based.

## Project Goal

The main goal of this project is to build a prototype of an ACS to demonstrate to users/clients and to gain knowledge about the problem and how to solve it before building the actual application.

In this project, we will develop two key parts of an ACS:

1. The "cloud" ACU as a web server, which will actually run locally on your desktop computer but communicating through the internet with a client simulator (a web page) and later a mobile app.

Please note that at this stage, only the logic part of the web server has been implemented. There is no application yet.

