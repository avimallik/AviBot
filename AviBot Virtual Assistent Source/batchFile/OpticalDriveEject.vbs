Set WMP = CreateObject("WMPlayer.OCX.7" )
Set CDROMs = WMP.cdromCollection

If CDROMs.Count >= 1 Then
For i = 0 to CDROMs.Count - 1
 CDROMs.Item(i).Eject
Next
End If