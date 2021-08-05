def merge_sort(arr):

  if len(arr) <= 1:
    return arr
    
  mid = len(arr) // 2
  
  left_arr = merge_sort(arr[:mid])
  right_arr = merge_sort(arr[mid:])

  return merge(left_arr, right_arr, arr.copy())

def merge(left_arr, right_arr, arr):

  i, j = 0, 0
  
  while i < len(left_arr) and j < len(right_arr):
    if left_arr[i] < right_arr[j]:
      arr[i + j] = left_arr[i]
      i += 1
    else:
      arr[i + j] = right_arr[j]
      j += 1

  for i in range(i, len(left_arr)):
      arr[i + j] = left_arr[i]
  for j in range(j, len(right_arr)):
      arr[i + j] = right_arr[j]

  return arr
