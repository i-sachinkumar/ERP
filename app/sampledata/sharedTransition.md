### Shared Transition MVVM
[video tutorial](https://www.youtube.com/watch?v=KuV8Y9-T-oA&ab_channel=PhilippLackner)
#### Transition API
1. Fade
2. Slide
3. Explode
4. ChangeBound
5. TransitionSet
6. AutoTransition

#### steps to implement transitions
1. xml code
2. kotlin code

in xml we have to provide unique transitionName to each element we want to animate

#### kotlin code, in Source fragment:
```kotlin
val extras = FragmentNavigatorExtras(
    binding.hiStudentName to "go_back_btn_profile",
    binding.session to "done_button_profile",
    binding.profilePic to "profile_pic_profile",
    binding.bottomPart to "foreground_profile"
)
findNavController().navigate(
    R.id.action_home_page_fragment_to_profile_fragment,
    null,
    null,
    extras,
)
```

#### In destination fragment in OnCreate() method:
```kotlin
//android.R.transition.move is default transition in android
//you can create custom transition (sample given below)
val animation = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)

sharedElementEnterTransition = animation
sharedElementReturnTransition = animation
```


#### custom transition xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<autoTransition xmlns:android="http://schemas.android.com/apk/res/android"
    android:transitionName="my_transition"
    android:duration="500">
</autoTransition>
```
 