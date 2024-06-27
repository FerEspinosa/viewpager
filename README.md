# viewpager
simple android app that shows implementation of viewpager


Create fragment state adapter

1- Create a new Java class "MyViewPagerAdapter"

2- ViewPager (v.1)     --> extends FragmentStatePagerAdapter  (deprecated on v.2)
     ViewPager2          --> extends FragmentStateAdapter

3- Implement the methods (2) and create the constructor (fragment manager one)

4- Declare and initiaize:
      private ArrayList <Fragment> fragmentList = new ArrayList <>() ;

5- On method createFragment:
      return fragmentList.get(position);

6- create a method:
      public void addFragment (Fragment fragment){
               fragmentList.add(fragment);
      }


Joining everything together:
      
1- declare on MainActivity and initialize on onCretate:
ViewPager2 viewpager;

myAdapter = new MyViewPagerAdapter(
         getSupportFragmentManager(),
         getLifecycle() );

2- Add the fragments in the viewpager

myAdapter.addFragment(new Fragment1());
myAdapter.addFragment(new Fragment2());
myAdapter.addFragment(new Fragment3());



// Set the orientation in viewpager2:
viewpager = findViewById(R.id.viewpager2);
viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
