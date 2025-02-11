/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filmmanagement;

class RevenueHistory {
    private Stack<Double> revenueStack; // Gelir hesaplamalarını saklayan Stack

    public RevenueHistory() {
        revenueStack = new Stack<>();
    }

    // Yeni bir gelir hesaplamasını kaydet
    public void recordRevenue(double revenue) {
        revenueStack.push(revenue);
    }

    // Son n gelir hesaplamasını getir
    public void getLastNRevenues(int n) {
        System.out.println("Last " + n + " Revenue Calculations:");
        Stack<Double> tempStack = new Stack<>();
        int count = 0;

        // Stack'teki son n elemanı geçici bir stack'e taşı
        while (!revenueStack.isEmpty() && count < n) {
            Double revenue = revenueStack.pop();
            System.out.println("Revenue: $" + revenue);
            tempStack.push(revenue);
            count++;
        }

        // Elemanları orijinal stack'e geri yükle
        while (!tempStack.isEmpty()) {
            revenueStack.push(tempStack.pop());
        }
    }
}
