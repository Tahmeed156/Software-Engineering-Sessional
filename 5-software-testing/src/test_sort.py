import pytest
from collections import defaultdict
from random import randint, sample, random

from sort import merge_sort as sort_func


# ================== check sorting ================== 


def check_order(result):
  
  for i in range(1, len(result)):
    
    # pair-wise elements are in ascending order
    if result[i] < result [i-1]:
      return False

  return True

def check_invariance(result, inp):
  
  # both lists are of same length
  if len(result) != len(inp):
    return False
  
  # list of element counts
  dict_1 = defaultdict(lambda: 0)
  for i in result:
    dict_1[i] += 1
  dict_2 = defaultdict(lambda: 0)
  for i in inp:
    dict_2[i] += 1
    
  # matching elemnt counts
  for elem, count in dict_1.items():
    if dict_2[elem] != count:
      return False
  
  return True


# ================== test cases ================== 


def test_blank_list():
  result = sort_func([])
  
  assert check_order(result), "Not ascending order"
  assert check_invariance(result, []), "Not original list"


@pytest.mark.parametrize("inp", [[0], [-5], [5], [9999]])
def test_one_number(inp):
  result = sort_func(inp)
  
  assert check_order(result), "Not ascending order"
  assert check_invariance(result, inp), "Not original list"


@pytest.mark.parametrize("inp", [[3, 2], [0, 0], [-3, 0], [-5, 3]])
def test_two_numbers(inp):
  result = sort_func(inp)
  
  assert check_order(result), "Not ascending order"
  assert check_invariance(result, inp), "Not original list"


def test_random_size():
  size = randint(3, 100)
  inp = sample(range(0, size), size)
  result = sort_func(inp)
  
  assert check_order(result), "Not ascending order"
  assert check_invariance(result, inp), "Not original list"


def test_random_numbers():
  inp = []
  for i in range(100):
    inp.append(randint(-100, 100))
  result = sort_func(inp)
  
  assert check_order(result), "Not ascending order"
  assert check_invariance(result, inp), "Not original list"


def test_ascending_list():
  inp = [0] * 100
  for i in range(1, 100):
    inp[i] = inp[i-1] + randint(1, 5)
  result = sort_func(inp)
  
  assert check_order(result), "Not ascending order"
  assert check_invariance(result, inp), "Not original list"


def test_descending_list():
  inp = [500] * 100
  for i in range(1, 100):
    inp[i] = inp[i-1] - randint(1, 5)
  result = sort_func(inp)
  
  assert check_order(result), "Not ascending order"
  assert check_invariance(result, inp), "Not original list"


def test_descending_list():
  inp = [randint(-100, 100)] * 100
  result = sort_func(inp)
  
  assert check_order(result), "Not ascending order"
  assert check_invariance(result, inp), "Not original list"


# ================== extra cases ================== 


def test_negative_list():
  inp = [-1] * 100
  for i in range(1, 100):
    inp[i] = inp[i-1] - randint(1, 5)
  result = sort_func(inp)
  
  assert check_order(result), "Not ascending order"
  assert check_invariance(result, inp), "Not original list"


def test_fraction_list():
  inp = []
  for i in range(100):
    inp.append(random() * 100)
  result = sort_func(inp)
  
  assert check_order(result), "Not ascending order"
  assert check_invariance(result, inp), "Not original list"


def test_large_values():
  ''' max = 1e6-1 '''
  inp = []
  for i in range(100):
    inp.append(randint(1e5, 1e6-1))
  result = sort_func(inp)
  
  assert check_order(result), "Not ascending order"
  assert check_invariance(result, inp), "Not original list"


def test_large_list():
  ''' max = 1e6-1 '''
  inp = [1] * int(1e6-1)
  for i in range(1, int(1e6-1)):
    inp[i] = randint(-5000, 5000)
  result = sort_func(inp)
  
  assert check_order(result), "Not ascending order"
  assert check_invariance(result, inp), "Not original list"
