# NavigationGDSC
This is a tutorial on how to create a Navigation component in Android JetPack Compose.
With navigation in Jetpack Compose we need some core elements which are:

1. a class that will hold the routes in this case, we have used a sealed class called NavigationClass.  
2. create objects that will inherit from that navigation class
3. create the composables/screens you want to navigate between and link them with the routes using the NaVHost and NavHostController.
4. create a navigation Bar composables for each of the screens.
5. create a scaffold that will take the navigation bar composable as an argument for the bottomBar lambda
6. Voila! You have a navigation app...![Screenshot 2023-11-15 085923](https://github.com/ggetiria/NavigationGDSC/assets/84561282/9a033ad4-23aa-4df9-901c-3c04d5a10aaa)
