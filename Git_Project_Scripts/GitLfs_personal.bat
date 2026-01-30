@echo off
cd /d "C:\Users\1767\eclipse-workspace\slotsAutomationPoC"

echo Deleting existing .git folder...
rmdir /s /q .git

echo Initializing new Git repository...
git init
git lfs install

echo Tracking large files with Git LFS...
git lfs track "*.dll"
git lfs track "*.pdb"
git lfs track "jdk-21.0.7/lib/modules"

echo Adding files to Git...
git add .gitattributes
git add .

echo Committing files...
git commit -m "Committing slots automation project with all large dlls of OpenCV, Tesseract and jdk/lib/modules"

echo Setting remote origin...
git remote add origin https://github.com/DevanshAgarwal760/SlotsPoC.git

echo Renaming branch to master...
git branch -M master

echo Force pushing to GitHub...
git push -u --force origin master

echo Done!
pause
