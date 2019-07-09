

outputString=`python time.py fuck`
#echo $outputString

IFS=' ' # space is set as delimiter
read -ra ADDR <<< "$outputString"
index=0
for i in "${ADDR[@]}"; do 
	echo index is $index
    IFS='-' # space is set as delimiter
	read -ra ADDR <<< "$i"
	startTime=${ADDR[0]}
	endTime=${ADDR[1]}
	ffmpeg -i Eminem-Not-Afraid.wav -filter_complex "[0]atrim=duration=$startTime[a];[0]atrim=start=$endTime[b];[a][b]concat=n=2:v=0:a=1" output$index.wav
	index=$((index+1))
	break
done
