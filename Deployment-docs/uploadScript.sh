#!/bin/bash
swiftURL='http://114.143.194.158:8102/auth/v1.0/'
path='/Users/CS93/Desktop/scripts/'
swiftPassword='pass@123'
swiftAccount='external'
swiftUser='external'
head=true
while IFS= read -r line; do 
    if $head; then 
        if [[ -z $line ]]; then 
            head=false
        else 
          if [[ $line == *"X-Auth-Token"* ]]; then
            token=$line
          else 
            if [[ $line == *"X-Storage-Url"* ]]; then
              storageUrl=${line:15}
            fi
          fi
        fi
    fi
done < <(curl -i -H "X-Auth-User: $swiftAccount:$swiftUser" -H "X-Auth-Key: $swiftPassword" $swiftURL)
#printf "%s\n" "${headers[@]}"
storageUrl=$(echo "$storageUrl" | tr -d '\r')
token=$(echo "$token" | tr -d '\r')
echo "SUCCESS AUTHENTICATING!"
echo "token : $token"
echo "url : $storageUrl"
thumbError="$path/thumbError.txt"
imageError="$path/imageError.txt"
iconError="$path/iconError.txt"
thumbSuccess="$path/thumbSuccess.txt"
imageSuccess="$path/imageSuccess.txt"
iconSuccess="$path/iconSuccess.txt"

echo "ERRORS" > $thumbError
echo "ERRORS" > $imageError
echo "ERRORS" > $iconError
echo "SUCCESS" > $thumbSuccess
echo "SUCCESS" > $imageSuccess
echo "SUCCESS" > $iconSuccess

IFS=","
i=0
while read fileName assetId thumbkey
do 
    i=$((i+1))
    echo "--------------- Image $i ------------------"
    fileName=$( echo "$fileName"| cut -d'"' -f 2 )
    echo "Without SubString : $fileName"
    assetId=$( echo "$assetId"| cut -d'"' -f 2 )
    thumbkey=$( echo "$thumbkey"| cut -d'"' -f 2 )

    extension=$( echo "$fileName" | rev | cut -d"." -f1  | rev)
    name=$( echo "$fileName" | rev | cut -d"." -f2-  | rev)
    nameLen=${#name}
    if [[ $nameLen -gt 38 ]]; then
      nameLen=${#name}-37
    fi

    fileName="${name:0:$nameLen}.$extension"
    echo "fileName  : $fileName"
    echo "assetId  : $assetId"
    echo "thumbkey  : $thumbkey"
    url="$storageUrl/Image/"
    thumbPath="$path/thumbs/$thumbkey.png"
    imagePath="$path/images/$fileName"
    contentThumb="$(curl --write-out %{http_code} --silent --output /dev/null -i "$url$thumbkey" -X PUT -T $thumbPath -H "Content-Type: image/*; charset=UTF-8" -H "$token" -H "X-Object-Meta-Name: $fileName" -H "X-Object-Meta-Format: $extension" -o $thumbError)"
    echo "Thumb Status : $contentThumb"
    if [[ ( $contentThumb -eq 201 ) || ( $contentThumb -eq 200 ) ]]; then
      echo "$thumbPath" >> $thumbSuccess
    else 
      echo "$thumbPath" >> $thumbError
    fi
    contentImage="$(curl --write-out %{http_code} --silent --output /dev/null -i "$url$assetId" -X PUT -T $imagePath -H "Content-Type: image/*; charset=UTF-8" -H "$token" -H "X-Object-Meta-Name: $fileName" -H "X-Object-Meta-Format: $extension" -o $imageError)"
    echo "Image Status : $contentImage"
    if [[ ( $contentImage -eq 201 ) || ( $contentImage -eq 200 ) ]]; then
      echo "$imagePath" >> $imageSuccess
    else 
      echo "$imagePath" >> $imageError
    fi
    echo "Count : $i"
    echo "-----------------------------------------"
done < Image.csv

echo "\n\nUploading Icons....................."   
i=0
while read iconId
do 
    i=$((i+1))
    echo "--------------- Icon $i ------------------"
    iconId=$( echo "$iconId"| cut -d'"' -f 2 )
    echo "iconId  : $iconId"
    url="$storageUrl/Icons/$iconId"
    iconPath="$path/icons/$iconId"
    content="$(curl --write-out %{http_code} --silent --output /dev/null -i "$url" -X PUT -T $iconPath.png -H "Content-Type: image/*; charset=UTF-8" -H "$token" -o $iconError)"
    echo "Icon Status : $content"
    if [[ ( $content -eq 201 ) || ( $content -eq 200 ) ]]; then
      echo "$iconPath" >> $iconSuccess
    else 
      echo "$iconPath" >> $iconError
    fi
    echo "-----------------------------------------"
done < Icons.csv

