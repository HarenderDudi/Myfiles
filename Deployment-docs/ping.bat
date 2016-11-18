echo "VM Results"
ping -n 100 192.168.134.224 >> 1531_Hrs_192.168.134.224.txt

echo "Pheonix Results"
ping -n 100 192.168.134.21 >>  1531_Hrs_192.168.134.21.txt

echo "Firewall Results"
ping -n 100 192.168.133.1 >>  1531_Hrs_192.168.133.1.txt

echo "DNS1 Results"
ping -n 100 202.149.208.91 >>  1531_Hrs_202.149.208.91.txt

echo "DNS2 Results"
ping -n 100 202.149.208.92 >>  1531_Hrs_202.149.208.92.txt

echo "Google DNS Results"
ping -n 100 8.8.8.8 >>  1531_Hrs_ 8.8.8.8.txt
 
echo "Pheonix Results"
ping -n 100 192.168.135.48 >>  1531_Hrs_192.168.135.48.txt