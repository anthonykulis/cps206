# Git and Github

## Git
Git is a peer-to-peer version control system (VCS) that allows a use to, you guessed it, version their code. Because your code is versioned, you can roll back to another version if so needed. Think of all the times you created

    myHomework.java
    myHomework2.java
    myHomework3.java
    
Git will remove that mess forever. 



### Basic Git usage
Without the desktop toolkit, there are four basic commands you should know plus 2 basic setup commands.

#### Setup Commands
Either you are creating a new git repository or you are using an existing one. Lets first look at setting up a new one since it is the simplest.

In your projects root directory, simply type

    git init
    
That's it. You can now use version control. One caveat, if you are creating a new repository and want to push it to a remote one, e.g. github, you will need that repositories url. Imagine your repository is `https://github.com/yournamehere/myrepo.git`, you would need to add a `remote` with

    git remote add origin https://github.com/yournamehere/myrepo.git
   


If you wish to use an existing repository on a different computer (one where it has never been before), you can `clone` the repository. For instance to clone the csp206 repository (which you're free and encouraged to do), simply type 

    git clone https://github.com/anthonykulis/cps206.git
    
This will create in your current working directory a directory named `cps206` that has everything I have online on your local computer. 

 

#### Add
Adding in git allows you to tell git that whatever file you added should be versioned. Typically you can do this in bulk, but you can also do this file by file. It basic notation is as such

    git add [files]
    
When I use `[]` in command line, it means something is required to replace the `[]`. So as I mentioned, adding in bulk we can use `.` to say "all files in this directory". Example:
    
    git add .
    
This will tell git to add all files in this current directory *downwards* that are not versioned should be added.

Optionally, if you just wanted to add one file, say `myApplication.java`, you could restrict the add feature as such:

    git add myApplication.java
    
 
#### Commit
Committing a file means that the recently added files, or modified files, are ready to be versioned. To use commit, simply type:

    git commit -am 'my commit message, such as - i fixed a bug here'
 
The `-am` tells git to set the message "my commit message, such as - i fixed a bug" to the current commit. This way, when reviewing your commits, you can reference why you committed. Make sure to use a good message that means something to you (or another engineer) in the future.

#### Push
Pushing a commit (or multiple commits) means you share your commits with a remote git repository. Since I am assuming your created a github repository named `myrepo` and have set up the remote named `origin` in the setup steps, to push previously committed code to that repository, simply type

    git push origin master
    
You get a message saying the remote repository is ahead of your local one, this occurred because you changed code somewhere else first and on this local machine it is out of date. Being said, you should always `pull` before you `add` or `commit`

#### Pull
Pulling a commit, or a series of commits, is meant to update your local machine with the "head" of the repository. Before you start any work, (or add and commit if you are in teams on the same repository), you should pull the code down from the remote to your local with

    git pull origin master
    
## Github Desktop For Windows

I am not a windows user. I will update this with a url that demos the above git commands.

### Advanced Git Topics
For this course, there are only two *advanced* topics I suggest you worry about, *branching* and *stashing*. 

#### Branching
Branching allows you to *branch* off of a another branch to create a new feature. Branching requires that your previous work from the branch you are branching off of is committed or stashed. If you branch with non-committed or non-stashed work, it will follow you into the new branch while removing itself from the previous branch. 

To core branch is called *master*. Imagine I created a repository for lab 2 (POJOs). When I first create that repository and initialize it, I will have this one *master* branch.

Now imagine from my UML design I know I will have 3 classes, `SodaBottle`, `Lid`, `Label`. Each of these classes is a *feature*. I do not have to have a `SodaBottle` to have a `Lid`, nor do I have to have a `Lid` to have a `Label`. Being said, I can first create my `Label` class. 

The proper technique for this would be to branch on each feature, complete it, and then merge back into master. So lets do that. But before I do, let us use git to show our current branch.

	git branch
	

If you previously initialized the repository with some code or README file, git will reply with 

	* master
	
	
If I have not previously initialized the repository, git will reply with nothing. In this case, create a README.md file, add some markdown, type `git add .`, then `git commit -am 'init'`. At this point it will say `1 file changed...`, and if you reapply the previous `git branch` command, it will now look like:

	* master

Now that we have realized we are on the master branch, we will continue onwards with our demonstration. First, I will create the `Label` class. This means, from the *master* branch, I will branch into *create-label-class*.

	git checkout -b create-label-class
	
Here, *git* is our git binary we will run. *checkout* tells git to switch from its current branch, in this case master, to *create-label-branch*. But since it doesn't exist yet, the *-b* flag tells git to create the branch. Git will reply 
with: 

	Switched to a new branch 'create-label-class'

Now if I did the following again:

	git branch
	
Git will now have both *master* and *create-label-class*, but with the active branch set to *create-label-class*. The
 `checkout` option told git to set this branch active.
 
 	* create-label-class
 	master
 	
Git holds the branches in alphabetical order, so do not assume because it is listed first, that it is the active 
branch. Use the * as reference.

Ok, now that we have the proper branch, let's add some source code. For this tutorial, we will simply add our `Label
.java` file with the command. If you are using windows, you may have to use the gui to create this.

	touch Label.java
	
To demonstrate what is happening currently, type the following:

	git status
	
You will see git reply with 

	On branch create-label-class
    Untracked files:
      (use "git add <file>..." to include in what will be committed)
    
            Label.java
    
    nothing added to commit but untracked files present (use "git add" to track)

This is because we have not added our `Label.java` file to versioning. git suggests usinng "git add" to do so, so let's

	git add .
	
	
Now if you use `git status` again, git will tell you:
	
	On branch create-label-class
    Changes to be committed:
      (use "git reset HEAD <file>..." to unstage)
    
            new file:   Label.java
    

This means you have created a new file, but have failed to commit it. So let us commit it.

	git commit -am 'creates an empty Label.java file'
	
And git will reply with 

	[create-label-class 8bb5f01] creates an empty Label.java file
     1 file changed, 0 insertions(+), 0 deletions(-)
     create mode 100644 Label.java

Now your code is committed. It is not in *master* yet, it is still on your feature branch. Now lets fast forward, 
imagining we created this class, tested it, and are ready to merge it back into master.
	
	git checkout master
	
Now if you checkout master, and you have committed all your code on the other branch, you can type 

	git branch 

and see the following:

	create-label-class
    * master

Notice how we didn't use the *-b* flag to create master? That is because we are only switching branches, not creatind
 and switching. 
 
Now that we are in master, before we merge in our feature, if you type `ls` (or `dir` on windows), you will see that 
`Label.java` does not exist. This is because it is still on the `create-label-branch`. You can checkout that branch, 
`ls` it again, and see your `Label.java` file if you so wish, or you can just trust me and we can move on.


While in *master* type, 

	git merge create-label-class
	
and git will reply with the following

	Updating ce5b681..8bb5f01
	Fast-forward
	 Label.java | 0
	 1 file changed, 0 insertions(+), 0 deletions(-)
	 create mode 100644 Label.java

Now if you `ls` again, `Label.java` will be listed. You have now successfully branched and merged. Since I have 
completed `Label`, I would now branch for the `Lid` feature, finish it, merge it into master, then finally branch 
into `SodaBottle`, use `Lid` and `Label` to build my `SodaBottle`, then merge that feature into master. Following 
this work flow will allow for you have good solid features you can roll back on if needed, and allow your team to 
work on independent features (eg `Lid` and `Label`) simultaneously.

#### Conflict!
Did you get a conflict? Well that would be because you changed a file that git couldn't automatically merge. If you 
run into this issue, contact me and I will help you navigate the problem. This occurs because you modified existing 
code in your new branch that existed in the previous branch that upon merge, couldn't be resolved. 

If you are branching on features, and do it as I have suggested, you will not run into this problem. If you branch a 
feature and then lose focus and work on a non-feature related item (eg you branched to create Label but ended up 
working on SodaBottle), you very well could run into a conflict.
	
### Stashing

Stashing is a feature I use a *lot*. Stashing is like committing, but without the commitment. Imagine I have been 
working on a feature and I realize that maybe I am heading the wrong direction with it and want to test another 
direction out. Well if I commit my previous work, I am committed to it. Instead, I can stash that work, returning to 
it only if I want to.

Let us use our `Label` class as an example again and have written some precarious code. It doesn't matter what branch I
 am on, stash works just fine. I dont want to add/commit, I just want to stash
 
 	git stash
 	
git will reply with something similar

	Saved working directory and index state WIP on master: 8bb5f01 creates an empty Label.java file
    HEAD is now at 8bb5f01 creates an empty Label.java file

Now if you inspect your source code, everything you have done since the last commit is "stashed" away. You are free 
to explore other ideas. Lets say your idea didn't pan out and you want to return to your old source. There are a ton 
of options, and I suggest you [exploring](https://git-scm.com/docs/git-stash) them, but for this tutorial, we will 
only stash one at time and remove one at a time.

But before you explore other ideas, the behavior I use is that once I stash to try out an idea, I branch into that 
idea. This way I can easily drop (or merge) that idea once complete. Since we already covered branching, I will 
assume you have returned to your stash and want to recover it.

	git stash pop
	
The `pop` argument will tell git to take the *last* stash and bring it into the current work. If you have not 
previously branched and did work, you will be told that you have uncommitted work and it cannot merge the pop back in
. This is why I suggest you branch into your idea from your current branch and when completed, checkout out the 
previous branch, merge in any new changes if needed. If you didn't like your changes, you can just delete that 
experiment branch, and pop your stash