clc
clear all
close all

%getting the path of the training folder and creating an image datastore to store the training and testing data
setDir  = fullfile('training');

%labelling each image with the name of its respective folder
imds = imageDatastore(setDir,'IncludeSubfolders',true,'LabelSource',...
    'foldernames');

%splitting the images into the training and testing as 70% and 30% respectively and adding pictures to them randomly (hence different
%accuracies on each run)
[trainingSet,testSet] = splitEachLabel(imds,0.2,'randomize');

%extracts same number of features from each folder images (based on the number of min features) using computer vision toolbox
bag = bagOfFeatures(trainingSet);

%trains the images using computer vision toolbox 
categoryClassifier = trainImageCategoryClassifier(trainingSet,bag);

%used to evaluate the accuracy of the model returns n*n matrix where n is the number of classifications, here 3
confMatrix = evaluate(categoryClassifier,testSet)
mean(diag(confMatrix))

%reads the image 
img=imread('C:\Users\Dell\OneDrive\Desktop\ps1 2021\final\test6.jpg');
imshow(img)
[labelIdx,score] = predict(categoryClassifier, img);
%prints an array containing the ans 
categoryClassifier.Labels(labelIdx)

% Normalizes image (0 to 1, by default)
navg=mean( reshape( img, [], 3 ), 1 )/255; 
rbyg= navg(1)/navg(2);
gbyb = navg(2)/navg(3);
bbyr = navg(3)/navg(1);

%based on the observations from the universal indicator chart
if((rbyg>1.65) && (gbyb> 1.1) && bbyr< 0.5)
    ph='pH is less than 4';
elseif(((rbyg>=1.65) && (rbyg<=1.029)) &&((gbyb>=1.1) &&(gbyb<=1.923)) &&((bbyr>=0.54) && (bbyr<=1.07)))
    ph='pH is between 4 and 6'; 
else
    ph='pH is greater than 7';
end

ans = [ph , ' for the given soil sample'];
disp(ans)

%sending a mail notification to the user informing about completion of
%processing
setpref('Internet', 'SMTP_Server', 'smtp.gmail.com');
setpref('Internet', 'E_Mail','xxxx'); %from email address
setpref('Internet', 'SMTP_Username', 'xxxxx'); % email address
setpref('Internet','SMTP_Password', 'yyyyy'); %password

%setting the access properties
props = java.lang.System.getProperties;
props.setProperty('mail.smtp.auth','true');
props.setProperty('mail.smtp.starttls.enable','true');

sendmail('zzzzz', 'matlab test mail', 'this is a sample mail with attachment','C:\Users\Dell\OneDrive\Desktop\ps1 2021\final\test5.jpg' );



