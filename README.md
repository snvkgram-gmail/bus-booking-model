# bus-booking-model
An application to book a bus between any given two cities.

Requirements:
A Transport company has buses to shuttle between any cities.
Each Bus shuttles between two cities.

	A customer should be able to search the available buses from the origin city.
	A Customer can check the availability on a given day.
	A Customer can make a booking by selecting a date and origin city (& destination city).

	Rudra is curious to see how the data model will store the bus bookings with date.

	Questions:
	Do we need a Bus Service?
	If so, Bus should be referred by a Transport Service provider.
	So, we can make this out of scope for the sake of simplicity.


	Iteration 2:
	Add operational status to Bus.
	Add a method to TransportService to return only Operational Buses.
	Buses configured for each date (in a month). This will demand different way storing & retrieving buses.
