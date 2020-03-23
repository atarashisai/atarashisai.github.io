```python
def permute(string : list, alpha : int, omega : int, index : int):
    if alpha == omega:
        return ["".join(string)]
    if index == omega+1:
        return []

    string[alpha], string[index] = string[index], string[alpha]
    results = permute(string, alpha+1, omega, alpha+1)
    string[alpha], string[index] = string[index], string[alpha]
    return results + permute(string, alpha, omega, index+1)

def main():
    input_string = list("abc")
    results = permute(input_string, 0, len(input_string)-1, 0)
    assert(results[0]=='abc')
    assert(results[1]=='acb')
    assert(results[2]=='bac')
    assert(results[3]=='bca')
    assert(results[4]=='cba')
    assert(results[5]=='cab')

if __name__ == "__main__":
    main()
    pass
```