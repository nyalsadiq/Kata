# Pluto Rover Kata

## Further Changes:
* I would scrap the use of Enums for direction, so instead of using NORTH/SOUTH etc I could use the degree system (0/90/180) as it would make my move & turn functions less verbose - we could just add and subtract 90 degrees whenever we want to turn. This would also mean we could to turn more freely and not just in terms of 90 degrees. 
* I would consider making the Map class the main component of the library and not just a singleton to store obstacles. It would mean we could add multiple Rovers if we wanted.
* About multiple Rovers, we could use a cool publisher/subscriber style pattern to send signals to each rover.
