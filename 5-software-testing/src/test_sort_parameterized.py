import pytest
from collections import defaultdict
from random import randint, sample, random

from sort import merge_sort as sort_func


@pytest.mark.parametrize("inp", [
  [], # blank list
  [5], # single number
  [3, 2], # two numbers
  sample(range(2000), randint(5, 2000)), # random size
  [randint(5, 2000) for _ in range(100)], # random list
  [1, 3, 6, 20, 25], # ascending
  [20, 17, 14, 12, 5], # descending
  [3, 3, 3, 3, 3], # same number
  [-5, -10, 0, 1, -3], # negative list
  [1.25, 5.6, 2.3, 10.9, 7.2], # fraction list
  [randint(1e5, 1e6) for _ in range(100)], # large numbers
  sample(range(int(1e6)), int(1e6)), # large list
])
def test_order(inp):
  
  result = sort_func(inp)

  for i in range(1, len(result)):

    # pair-wise elements are in ascending order
    if result[i] < result [i-1]:
      assert False, "Not ascending order"


@pytest.mark.parametrize("inp", [
  [], # blank list
  [5], # single number
  [3, 2], # two numbers
  sample(range(2000), randint(5, 2000)), # random size
  [randint(5, 2000) for _ in range(100)], # random list
  [1, 3, 6, 20, 25], # ascending
  [20, 17, 14, 12, 5], # descending
  [3, 3, 3, 3, 3], # same number
  [-5, -10, 0, 1, -3], # negative list
  [1.25, 5.6, 2.3, 10.9, 7.2], # fraction list
  [randint(1e5, 1e6) for _ in range(100)], # large numbers
  sample(range(int(1e6)), int(1e6)), # large list
])
def test_invariance(inp):
  
  result = sort_func(inp)
  
  # both lists are of same length
  if len(result) != len(inp):
    assert False, "Lists are not of same length"
  
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
      assert False, "Not original list"
